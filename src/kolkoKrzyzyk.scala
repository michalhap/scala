import scala.Array.ofDim
import scala.util.control.Breaks.{break, breakable}

/**
  * Created by michal on 27.03.17.
  */

var numer: Int = 0
var plansza = ofDim[Int](3,3)
var skonczona: Boolean = false
print("Gracz 1 jest krzyzykiem, gracz 2 jest kolkiem.\n")
print("Podawajcie nr pol, 1-9, poszczegolne trojki sa wierszami planszy.\n")
var czyjRuch: Int = 1
while(skonczona == false){
  if (czyjRuch == 1) {
    print("Graczu 1, podaj nr pola.\n")
  }
  if (czyjRuch == -1){
    print("Graczu 2, podaj nr pola.\n")
  }
  numer = scala.io.StdIn.readInt()
  numer = numer - 1
  var wiersz: Int = numer / 3
  var kolumna: Int = numer % 3
  breakable{
    while(true){
      if (numer < 0 || numer > 8){
        print("Podaj poprawny numer (1-9).\n")
        break()
      }
      else{
        if(plansza(wiersz)(kolumna) == 0){
          plansza(wiersz)(kolumna) = czyjRuch
          czyjRuch = (-1)*(czyjRuch)
          grafika(plansza)
          break()
        }
        else{
          print("To pole jest zajete, podaj inny nr.\n")
          break()
        }
      }
    }
  }

  if (plansza(1)(1) != 0) {
    if (plansza(0)(0) == plansza(1)(1) && plansza(1)(1) == plansza(2)(2)) {
      ktoWygral(plansza(1)(1))
      skonczona = true
    }

    if (plansza(2)(0) == plansza(1)(1) && plansza(1)(1) == plansza(2)(0)) {
      ktoWygral(plansza(1)(1))
      skonczona = true
    }
  }

  for (x <- 0 to 2) {
    if (plansza(x)(0) != 0) {
      if (plansza(x)(0) == plansza(x)(1) && plansza(x)(0) == plansza(x)(2)) {
        ktoWygral(plansza(x)(0))
        skonczona = true
      }
    }
    if (plansza(0)(x) != 0){
      if (plansza(0)(x) == plansza(1)(x) && plansza(0)(x) == plansza(2)(x)){
        ktoWygral(plansza(0)(x))
        skonczona = true
      }
    }
  }

  var czyRemis: Boolean = true

  for( x <- 0 to 2){
    for( y <- 0 to 2){
      if (plansza(x)(y) == 0) {
        czyRemis = false
      }
    }
  }

  if (czyRemis == true){
    skonczona = true
    print("Remis.\n")
  }
}

def ktoWygral(a: Int): Unit ={
  if (a == 1){
    print("Koniec gry! Wygral gracz pierwszy.\n")
  }
  if (a == -1){
    print("Koniec gry! Wygral gracz drugi.\n")
  }
}

def grafika(plansza: Array[Array[Int]]): Unit ={
  for (x <- 0 to 2){
    for (y <- 0 to 2 ){
      if (plansza(x)(y) == 0){
        print(" ")
      }
      if (plansza(x)(y) == -1){
        print("O")
      }
      if (plansza(x)(y) == 1){
        print("X")
      }
      if (y == 0 || y == 1){
        print("|")
      }
    }
    print("\n")
    if (x == 0 || x == 1){
      print ("-----\n")
    }
  }
}