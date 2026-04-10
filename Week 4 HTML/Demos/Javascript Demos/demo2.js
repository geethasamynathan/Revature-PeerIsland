let name = "Geetha";
console.log(" name in outside function" + name);
var course = "Javascript";
console.log(course);

function sample() {
  let name = "Tina";
  console.log("name  inside sample : " + name);
  console.log("companyName : " + companyName);
  var companyName = "Peer Island";
}
name = "Peer Island";
sample();
var course = "Advanced Java";

const pi = 3.14;
