class Customer {
    constructor(id, customerNumber) {
        this.id = id
        this.customerNumber = customerNumber
    }
}

let print = (x) => {
    console.log(x);
}

let customer = new Customer(1, "12345");
//prototyping
customer.name = "Ahmet Emin"

print(customer.name)
Customer.demo = "demo";
print("Customer.demo : " + Customer.demo);
print("customer.id : " + customer.id)
print("customer.customerNumber : " + customer.customerNumber)


class IndividualCustomer extends Customer {
    constructor(firstName, id, customerNumber) {
        super(id, customerNumber)
        this.firstName = firstName;
    }


}

class CorporateCustomer extends Customer {
    constructor(companyName, id, customerNumber) {
        super(id, customerNumber)
        this.companyName = companyName

    }
}

let individualCustomer = new IndividualCustomer("Ahmet", 2, "123");
print(individualCustomer);


let products = [
    { id: 1, name: "Acer Laptop", unitPrice: 15000 },
    { id: 2, name: "Asus Laptop", unitPrice: 16000 },
    { id: 3, name: "Hp Laptop", unitPrice: 13000 },
    { id: 4, name: "Dell Laptop", unitPrice: 12000 },
    { id: 5, name: "Casper Laptop", unitPrice: 17000 },
]
print("<ul>")
products.map(product => print(`<li>${product.name}</li>`)) // `` ile '' arasinda cok fark var, `` olan {$var} olarak kullanilarak  deger yazdirir
print("</ul>")

/** state management : data degisinde ekran yeniden render edilir. angular, vue, react bu ozellk vardir */

let filteredProducts = products.filter(product => product.unitPrice > 15000)
console.log(filteredProducts);


/** her bir urun icin toplama hesaplamasi  accumulate ==> acc olmus. 
 * 0 ise baslangic degeri
 */
let cartTotal = products.reduce((acc, product) => acc + product.unitPrice, 0);
print(cartTotal)

let cartTotal2 = products
    .filter(p => p.unitPrice > 15000)
    .map(p => {
        p.unitPrice = p.unitPrice * 1.18
        return p;
    }).reduce((acc, p) => acc + p.unitPrice, 0)

print('------------------')
print(cartTotal2)
print('------------------')
products.map(p=>print(p.unitPrice))






