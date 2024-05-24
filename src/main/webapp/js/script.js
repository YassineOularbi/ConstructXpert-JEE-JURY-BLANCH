// password strenght

const bars = document.querySelector("#bars"),
    strenghtDiv = document.querySelector("#strenght"),
    passwordInput = document.querySelector("#password");

const strenght = {
    1: "weak",
    2: "medium",
    3: "strong",
};

const getIndicator = (password, strenghtValue) =>{
    strenghtValue.upper = /[A-Z]/.test(password);
    strenghtValue.lower = /[a-z]/.test(password);
    strenghtValue.numbers = /\d/.test(password);

    let strenghtIndicator = 0;

    for(let metric in strenghtValue){
        if(strenghtValue[metric] === true){
            strenghtIndicator++;
        }
    }
    return strenght[strenghtIndicator] ?? "";
};

const getStrenght = (password) => {
    let strenghtValue = {
        upper: false,
        numbers: false,
        lower: false,
    };

    return getIndicator(password, strenghtValue);
};

const handleChange = () =>{
    let { value: password } = passwordInput;

    console.log(password);

    const strenghtText = getStrenght(password);

    bars.classList = "";

    if (strenghtText) {
        strenghtDiv.innerText = `${strenghtText}`;
        strenghtDiv.style.margin = "0 5px";
        bars.classList.add(strenghtText);
    } else {
        strenghtDiv.innerText = "";
    }
};


// password hidden


const passwordButton = document.querySelector("#passwordButton");

const passwordIcon = document.querySelector("#passwordIcon");

const togglePassword = e => {
    e.stopPropagation();

    const { lenght: passwordLenght } = passwordInput.value;

    if(passwordIcon.innerText === "visibility"){
        passwordIcon.innerText = "visibility_off";
        passwordInput.type = "text";
    } else {
        passwordIcon.innerText = "visibility";
        passwordInput.type = "password";
    }
    if (passwordLenght){
        passwordInput.focus();
        InputDeviceInfo.setSelectionRange(passwordLenght, passwordLenght);
    }
};


// selection

document.addEventListener('DOMContentLoaded', function () {
  const materials = document.querySelectorAll('.wallMaterial');
  const selected = document.getElementById('wallMaterial-selected');
  const price = document.getElementById('wallMaterial-price')

  materials.forEach(function (material) {
      material.addEventListener('change', function () {
          materials.forEach(function (m) {
              m.closest('label').classList.remove('selected');
          });
          if (this.checked) {
              this.closest('label').classList.add('selected');
              selected.textContent = this.value;
              price.textContent = this.getAttribute("data-price");
          }
      });
  });
});

document.addEventListener('DOMContentLoaded', function () {
  const foundations = document.querySelectorAll('.foundationType');
  const selected = document.getElementById('foundationType-selected');
  const price = document.getElementById('foundationType-price')

  foundations.forEach(function (foundation) {
      foundation.addEventListener('change', function () {
          foundations.forEach(function (f) {
              f.closest('label').classList.remove('selected');
          });
          if (this.checked) {
              this.closest('label').classList.add('selected');
              selected.textContent = this.value;
              price.textContent = this.getAttribute("data-price");
          }
      });
  });
});

document.addEventListener('DOMContentLoaded', function () {
  const rooflings = document.querySelectorAll('.rooflingType');
  const selected = document.getElementById('rooflingType-selected');
  const price = document.getElementById('rooflingType-price')

  rooflings.forEach(function (roofling) {
      roofling.addEventListener('change', function () {
          rooflings.forEach(function (r) {
              r.closest('label').classList.remove('selected');
          });
          if (this.checked) {
              this.closest('label').classList.add('selected');
              selected.textContent = this.value;
              price.textContent = this.getAttribute("data-price");
          }
      });
  });
});

document.addEventListener('DOMContentLoaded', function () {
  const areasize = document.querySelector('.areaSize');
  const budget = document.querySelector('.budget');
  const priceWall = document.getElementById('wallMaterial-price')
  const priceFoundation = document.getElementById('foundationType-price')
  const priceRoofling = document.getElementById('rooflingType-price')

      areasize.addEventListener('input', function () {
          let comptebudget = (areasize.value * priceWall.textContent) + (areasize.value * priceFoundation.textContent) + (areasize.value * priceRoofling.textContent);
          budget.value = comptebudget;
      });
});