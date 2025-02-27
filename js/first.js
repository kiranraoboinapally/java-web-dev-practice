console.log('Hello all');
console.log("I am learning JavaScript");
console.log('This is my first JavaScript code')


//variables are containers for data .

fullName = "John Doe";
age=25;
console.log(fullName);
console.log(age);

x=null;
console.log(x);
y=undefined;
console.log(y);


isFollow=false;
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