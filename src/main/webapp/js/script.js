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