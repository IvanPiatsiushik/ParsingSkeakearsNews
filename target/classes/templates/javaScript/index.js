const currentYear = 2023
const rightAnswer = 'Вы знаете каккой нынче год'
const wrongAnswer = 'Вы ответили не правильно'

const button = document.querySelector('.js-button')
const input  = document.querySelector('.js-input')
let output = document.querySelector('.js-output')

console.log(button)
console.log(output)
console.log(input)
//
// button.addEventListener('click',function (){
//     const inputValue = input.value;
//     if(!inputValue){
//         return;
//     }
//     const answer = Number(input.value)
//     let output1 = rightAnswer
//     if(answer!== currentYear){
//         output1 = wrongAnswer
//     }
//     output.innerHTML = output1
// })

button.addEventListener('click',function(){
    if(input===currentYear){
        output = rightAnswer
    }
})


// function result(){
// if(button.onclik() === currentYear){
//     console.log(rightAnswer)
//
//     }
// }
// relust()

// const  inputNode    = document.querySelector('js-input')
// function greet (name){
//     console.log('My name is  ',name)
// const  buttonNode    = document.querySelector('js-button')
// const  outputNode    = document.querySelector('js-output')
// const fullAge = 34
// const birthYear = 1988  
// const currentYear = 2023
// const isFullAge = currentYear - birthYear == fullAge
// console.log(isFullAge)
// console.log(fullAge)
// const courseStatus = 'pending'
// if(courseStatus === 'ready'){
// 	console.log('Курс уже готов и его можно проходить')
// } else if(courseStatus === 'pending'){
// 	console.log('Курс пока находится в процессе разработки')
// }

// function calculateAge(year){
// 	return 2023 - year
// }
// const myAge = calculateAge(1988)
// console.log(calculateAge(2000))
// console.log(calculateAge(200))
// console.log(calculateAge(1200))
// function logInfoAbout(name,year){
// 	const age = calculateAge (year)
// 	console.log(name,age)
// }
//
// logInfoAbout('ivan',1988)

// 9 Arrays
// const cars = ['mazda','mers','bmw']
// // const cars = new Array('mazda','bmw')
//
// console.log(cars.length)
// console.log(cars[1])
// console.log(cars[2])
// console.log(cars[3])
//
// cars[0] = 'Porsche'
// console.log(cars[0])

// 10 For
// const cars = ['mazda','mers','bmw']
// console.log(cars)
//
// // for (let i = 0; i<cars ; i++){
// // 	const car = cars[i]
// // 	console.log(car)
// // }
// for (let car of cars){
// 	console.log(car)
// }

// 11 Объекты
const person = {
    firstName:'Ivan',
    lastName:'Piatsiushyk',
    age: 35,
    languages:['Ru','En'],
    hasWife: false,
    greet:function (){
        console.log('greet from person')
    }
}
console.log(person)
person.hasWife = true
person.greet()
console.log(person)
person.email = 'dirol-88@mail.ru'
console.log(person)



























