console.log('Hello all');
console.log("I am learning JavaScript");
console.log('This is my first JavaScript code')


//variables are containers for data .

fullName = "John Doe";
age=25;
console.log(typeof fullName);
console.log(fullName);
console.log(typeof age);
console.log(age);

x=null;
console.log('absence of an object '+typeof x);
console.log(x);
y=undefined;
console.log(typeof y);
console.log(y);


isFollow=false;
console.log(typeof isFollow);
console.log(isFollow);

fullName= 25;//dynamically typed language
console.log(fullName);


//variable rules ,variable are case sensitive
fullName= "John Smith";
_fullName= "John Smith";
$fullName= "John Smith";


//var:Variable can be re-declared and updated a global scope varible
//let:Variable can be updated but not re-declared a block scope variable
//const:Variable can neither be updated nor re-declared a block scope variable

let name="Tony Stark";
console.log(name);

let lastName="stark";
console.log(lastName);

//es6 EcmaScript 6

var num=23;
var num=34;
var num=45;
console.log('var can redeclared and updated '+num);

let num1=28;
let num2=39;
console.log('let cannot be redeclared '+num1+" "+num2);

let num3=60;
num3=70;
console.log('let can be updated '+num3);

const num4=90;
console.log('const cannot be updated '+num4);

const PI=3.14;
console.log('Using const for math which need not to be changed i.e fixed '+PI);


let a;
console.log('gets undefined because let not initialized'+a);

//const b;
//console.log('gets error because const not initialized'+b);


//blocks
{
    let z=2;
    console.log(z);
}
{
    let z=3;
    console.log(z);
}


//non-primitive data types are objects,arrays,functions