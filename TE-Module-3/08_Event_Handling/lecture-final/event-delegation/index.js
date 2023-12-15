const colors = document.getElementById("colors");
colors.addEventListener("click", event => {
	console.log(event.target.nodeName)
  if (event.target.nodeName.toLowerCase() === "li") {
    event.target.style.backgroundColor = event.target.innerText;
  }
});

function addColor() {
	const liRef = document.createElement('li');
	const colorPickerRef = document.getElementById('colorPicker');
	console.log('addColor was fired, here is the colorPicker', colorPickerRef.value)
	liRef.innerText = colorPickerRef.value;
	colors.appendChild(liRef);
}

document.addEventListener('DOMContentLoaded', () => {
	const button = document.getElementById('btnAddColor');
	button.addEventListener('click', addColor);
});