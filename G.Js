const musicBtn = document.getElementById("musicBtn");
const bgm = document.getElementById("bgm");

let playing = false;

musicBtn.addEventListener("click", () => {

if(!playing){
bgm.play();
musicBtn.textContent = "♫ ON";
playing = true;
}
else{
bgm.pause();
musicBtn.textContent = "♫ OFF";
playing = false;
}

});