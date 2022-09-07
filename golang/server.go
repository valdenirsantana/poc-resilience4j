package main

import (
	"encoding/json"
	"fmt"
	"net/http"
	"time"
)

const DATE_FORMAT = "2006-01-02 15:04:05"

var callCounter int

func main() {
	http.HandleFunc("/sku", getSkuData)
	http.HandleFunc("/shipping", getShippingData)

	fmt.Println("Servidor startado..")
	http.ListenAndServe(":8001", nil)
}

func getSkuData(w http.ResponseWriter, r *http.Request) {
	fmt.Println(time.Now().Format(DATE_FORMAT), " getsku")

	json.NewEncoder(w).Encode(getLocalSku())
}

type Sku struct {
	Id        string  `json:"id"`
	Price     float32 `json:"price"`
	Available bool    `json:"available"`
	Details   string  `json:"details"`
}

func getLocalSku() (sku Sku) {
	sku = Sku{"SKU0123456789", 100, true, "Sucess on call partner"}
	return
}

func getShippingData(w http.ResponseWriter, r *http.Request) {
	if callCounter < 4 {
		fmt.Println(time.Now().Format(DATE_FORMAT), " getShipping - ERROR", "Call N°: ", callCounter)
		http.Error(w, "Sever restarting, please wait.", http.StatusInternalServerError)
	} else {
		fmt.Println(time.Now().Format(DATE_FORMAT), " getShipping - SUCCESS", "Call N°: ", callCounter)
		json.NewEncoder(w).Encode(getShipping())
	}

	callCounter = callCounter + 1

	return
}

type Shipping struct {
	Cep          string  `json:"cep"`
	Price        float32 `json:"price"`
	DeliveryDate string  `json:"deliveryDate"`
}

func getShipping() (shipping Shipping) {
	shipping = Shipping{"88735000", 100, "10/10/2021"}
	return
}
