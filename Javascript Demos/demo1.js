// console.log("hello from Javascript");
// let name = "Geetha";
// console.log("Welcome " + name);

// let username = "Nivedha";
// let age = 25;
// let isStudent = true;
// let result;
// let emptyValue = null;

// console.log(typeof username);
// console.log(typeof age);
// console.log(typeof isStudent);
// console.log(typeof result);
// console.log(typeof emptyValue);

// console.log("5" + 2);
// console.log("5" - 2);
// console.log(true + 1);
// console.log(false + 12);

//// Array in Javascript
// let courses = ["core java", "my sql", "mongodb", "Gen AI"];

// for (let course of courses) {
//   console.log(course);
// }
// console.log("\n");
// courses.push("Azure");
// for (let course of courses) {
//   console.log(course);
// }
// console.log(courses[2]);

// let colours = new Array("Red", "Green", "Blue");
// console.log(colours);

// //Empty
// let names = [];
// names[0] = "Ananya";
// names[1] = "Deekshita";
// names[2] = "Harish";

// console.log(names);

// //mixed datatype with array
// let employee = ["Fransy", 101, "Female", "doctor"];
// console.log("employee details are");
// console.log(" Id =" + employee[1]);
// console.log(" Name =" + employee[0]);
// console.log(" Gender =" + employee[2]);
// console.log(" Designation =" + employee[3]);

// let text = "HTML, CSS, JavaScript,React Js,React Native";
// let courseArray = text.split(",");
// console.log(courseArray);

// let chars = Array.from("Hello");
// console.log(chars);

let names = ["Sam", "Tim", "Uma", "Rosy"];
names[2] = "Yash";
// console.log(names);
// console.log(names.length);

// for (let i = 0; i < names.length; i++) {
//   console.log(names[i]);
// }

for (let name of names) {
  console.log(name);
}

//ForEach

// // names.forEach(function (item, index) {
// //   console.log(index, item);
// // });

// // console.log("pop() " + names.pop());

// // console.log("\n After Pop");
// // names.forEach(function (item, index) {
// //   console.log(index, item);
// // });

// //unshift - .Addigin element at the beginning

// names.unshift("Geetha");
// console.log(names);

// //shift -> To remove first element
// console.log("\n after shift ");
// names.shift();
// console.log(names);

// // indexOf
// console.log(" Index of Yash " + names.indexOf("Yash"));

// names.push("Sam");

// //lastIndexOf
// console.log(" last Index of Sam " + names.lastIndexOf("Sam"));

// //includes
// console.log(names.includes("Rosy"));

let a = [1, 2];
let b = [3, 4];
let c = a.concat(b);
console.log(c);

console.log(names);
console.log(names.join(", "));

//slice -> extract values  stra,end(before the end value)

console.log(names.slice(1, 3));

// //splice -> remove range values (start,count)
// names.splice(1, 2);
// console.log(names);

//splice ->Addnew value (index,0,"new value")
names.splice(1, 0, "Tina");
console.log(names);

//splice ->Replace value (index,1,"new value")
names.splice(1, 1, "Harish");
console.log(names);

//reverse
names.reverse();
console.log(names);

//sort
names.sort();
console.log(names);

let numbers = [100, 25, 5, 78];
console.log(numbers);
numbers.sort();
console.log(numbers);

numbers.sort(function (a, b) {
  return a - b;
});

console.log(numbers);

//map

// let nums = [1, 2, 3, 4];
// let doubled = nums.map(function (n) {
//   return n * 2;
// });

// console.log(doubled);

// let nums = [5, 12, 18, 25];
// let result = nums.find(function (n) {
//   return n > 15;
// });

// // console.log(result);

// let nums = [5, 12, 18, 25];
// let result = nums.findIndex(function (n) {
//   return n > 10;
// });

// console.log(result);

// //some

// let nums = [1, 3, 5, 8];
// let hasEven = nums.some(function (n) {
//   return n % 2 == 0;
// });

// console.log(hasEven);

// //every
// let nums = [2, 4, 6, 8];
// let allEven = nums.every(function (n) {
//   return n % 2 == 0;
// });

// console.log(allEven);

//reduce

let nums = [10, 20, 30, 40];
let total = nums.reduce(function (sum, n) {
  return sum + n;
}, 0);

console.log(total);
