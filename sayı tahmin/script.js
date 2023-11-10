"use strict";
let rastgele = Number(Math.floor(Math.random() * 20 + 1));
let score = 20;
let kalanHamle = 10;
let highscore = 0;
console.log(rastgele);
document.querySelector(".check").addEventListener("click", function () {
  const deger = Number(document.querySelector(".guess").value);
  if (deger === rastgele) {
    document.querySelector(".number").textContent = rastgele;
    document.querySelector(".message").textContent = "🎉Correct Number!";
    document.querySelector("body").style.backgroundColor = "#60b347";
    document.querySelector(".number").style.width = "30rem";
    if (score > highscore) {
      highscore = score;
      document.querySelector(".highscore").textContent = highscore;
    }
  } else if (deger !== rastgele) {
    deger > rastgele
      ? (document.querySelector(".message").textContent = "📈Too high!")
      : (document.querySelector(".message").textContent = "📉Too low!");
    if (kalanHamle > 1) {
      score--;
      kalanHamle--;
      document.querySelector(".score").textContent = score;
      document.querySelector(".kalanHamle").textContent = kalanHamle;
    } else {
      score--;
      kalanHamle--;
      document.querySelector(".message").textContent = "🧨You lost the game!";
      document.querySelector(".score").textContent = score;
      document.querySelector(".kalanHamle").textContent = kalanHamle;
    }
  }
  if (!deger) {
    document.querySelector(".message").textContent = "⛔No number!";
  }
});
document.querySelector(".again").addEventListener("click", function () {
  score = 20;
  document.querySelector(".score").textContent = score;
  document.querySelector(".number").textContent = "?";
  document.querySelector(".message").textContent = "Start guessing...";
  document.querySelector("body").style.backgroundColor = "#222";
  document.querySelector(".number").style.width = "15rem";
  rastgele = Number(Math.floor(Math.random() * 20 + 1));
  document.querySelector(".guess").value = "";
  kalanHamle = 10;
  document.querySelector(".kalanHamle").textContent = kalanHamle;
});
