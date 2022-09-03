//function giris
function addToCard(productName = "UnSelected", quantitiy = null, empty) {
    console.log("product name :" + productName + " quantitiy : " + quantitiy + " / " + empty);
}

addToCard("Yumurta", 10)
addToCard()

let sayHello = (param = null) => {
    console.log("Hello World " + param);
}

sayHello("asd");

//function : obje gonderimi
function addToCard3(product) {
    console.log("Product : " + product.productName);
    console.log("Product : " + product.quantitiy);
    console.log("Product : " + product.unitPrice);

}
let print = (param) => { // I think this is better
    console.log(param);
}


let product2 = { productName: "Elma", unitPrice: 10, quantitiy: 5 }
addToCard3(product2);

// primitive ile obje gonderimi
let sayi1 = 10
let sayi2 = 20
sayi1 = sayi2
sayi2 = 100
print(sayi1) //prints 20  numbers value, object referans address

let sayi3 = "abc";
sayi1 = sayi3
sayi3 = "30"
print(sayi1)


// objeler Heapte dir
// primitiveler Stacktedir


//Function : Array gonderimi
let addToCard4 = (x) => {
    print(x);
}

let products = [
    { productName: "Apple", unitPrice: 10, quantitiy: 5 },
    { productName: "Pear", unitPrice: 10, quantitiy: 5 },
    { productName: "WaterMelon", unitPrice: 10, quantitiy: 5 }

]

addToCard4(products)

// once function yazilmali

let printArray = (...numbers) => {// rest operatoru : degisken onune 3 nokta konmasi
    print("------------")
    numbers.forEach(print);
}

printArray(20);
printArray(20, 30);
printArray(20, 30, 40);
printArray(20, 30, 40, 50);
printArray(20, 30, 40, 50, 60);

function add(bisey, ...numbers) {
    print(bisey)
    let total = 0;
    numbers.forEach(e => total += e);
    print(total)
}

add(20, 30, 40, 50, 60);

//math function 

print("Math function : ")
let numbers = [30, 10, 500, 600, 120];

console.log(numbers)
console.log(...numbers)
console.log(Math.max(numbers))
console.log(Math.max(...numbers))

//Arrayde Degisken tanimlama :
let [icAnadolu, marmara, karadeniz, [icAnadoluSehirleri, MarmaraSehirleri, KaradenizSehirleri]] = [
    { name: "Ic Anadolu", population: "20M" },
    { name: "Marmara", population: "30M" },
    { name: "Karadeniz", population: "10M" },
    [
        ["Ankara", "Konya"],
        ["Istanbul", "Bursa"],
        ["Sinop", "Trabzon"]
    ]
]

console.log(icAnadolu)
console.log(marmara)
console.log(karadeniz)
console.log(icAnadoluSehirleri)
console.log(MarmaraSehirleri)
console.log(KaradenizSehirleri)


let pName, newUnitPrice,newQuantitiy

/**
 * { productName: pName, unitPrice: newUnitPrice, quantitiy: newQuantitiy }= { productName: "Elma", unitPrice: 10, quantitiy: 5 }
 * Js yukaridaki kodu kod blogu olarak algiliyor. Kod blogu olmadigini anlatmak icin asagidaki gibi paranteze almaliyiz : */
({ productName: pName, unitPrice: newUnitPrice, quantitiy: newQuantitiy }= { productName: "Elma", unitPrice: 10, quantitiy: 5 })
print(pName)
print(newUnitPrice)
print(newQuantitiy)


function login({productName}){  
    /**  buraya objenin bir parametresi gonderilir o da bu sekilde  gelen objenin parametresi alinir.
     *  product.productName yerine kullanilir*/
    print("<h1>"+productName+"</h1>")
}

login(product2)