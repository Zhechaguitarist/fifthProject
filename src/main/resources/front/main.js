// const name = prompt('Введите имя')
alert('Hello, ' + prompt('Введите имя') + '! ' + (3 > 5))
function firstFunction(x) {
    return x + 5;
}
alert(firstFunction(6))
const cars = [];
for (let i = 0; i < 5; i++)
    cars[i] = i.toString()
for (let car of cars)
    console.log(car)