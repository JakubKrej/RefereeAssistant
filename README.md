# Asystent Sędziego

## Spis treści
* [Informacje](#informacje)
* [Technologie](#technologie)
* [Funkcje](#funkcje)
* [Zrzuty ekranów](#zrzuty-ekranów)
* [Status](#status)

## Informacje
Projekt Asystent Sędziego jest aplikacja webową. Projekt ma na celu rozwinięcie moich umiejętności w pracy z java, 
frameworkiem Spring i Hibernate oraz w tworzeniu wyglądów stron. Hobbistycznie zajmuję się sędziowaniem meczy piłkarskich, 
co przyczyniło się do powstania aplikacji, która będzie mogła w jednym miejscu zgromadzić dużą liczbę informacji 
przydatnych sędziom piłkarskim w ich pracy.

## Technologie
* Java
* Spring
* H2database
* Hibernate
* Css
* Html
* Thymelaf

## Funkcje
Funkcjonalności:
* Możliwość rejestracji przez nowych użytkowników
* Użytkownik o roli "USER" ma możliwosć dodania meczu, który został przez niego posędziowany.
* Użytkownik o roli "USER" ma możliwosć edytowania dodanego wcześniej przez użtykownika meczu.
* Użytkownik o roli "USER" ma możliwosć usunięcia dodanego wcześniej przez użytkownija meczu.
* Użytkownik o roli "USER" ma dostęp do informacji o swoich meczach, sędziach piłkarskich oraz klubach dodantych do bazy danych.
* Użytkownik o roli "ADMIN" ma dostęp do informacji o meczach, sędziach piłkarskich oraz klubach dodantych do bazy danych.
* Użytkownik o roli "ADMIN" ma możliwość edytowania informacji o meczach, użytkownikach i drużynach dostępnych w bazie danych.
* Użytkownik o roli "ADMIN" ma możliwość usuwania użytkowników, meczy oraz drużyn.

Nad czym pracuje:
* Dodanie funkcji dodawania drużyn przez użytkownika o roli "ADMIN" .
* Stworzenie mockupu dla powyższej funkcji.
* Usprawnienie funkcji edytowania danych użytkowników.
* Usprawnienie funkcji edytowania danych drużyn i meczy.

## Zrzuty ekranów

Ekran logowania.

![Example screenshot](./img/login.jpg)

![Example screenshot](./img/login.err.jpg)

Ekran rejestracji.

![Example screenshot](./img/register.jpg)

![Example screenshot](./img/register.err.jpg)

![Example screenshot](./img/register.err.r.jpg)

Ekran użytkownika o roli "USER" po zalogowaniu.

![Example screenshot](./img/ushome.jpg)

Ekran użytkownika w zakładce "mecze".

![Example screenshot](./img/usmecze.jpg)

Ekran użytkownika - dodaj mecz.

![Example screenshot](./img/usdodajmecz.jpg)

Ekran użytkownika, na którym użytkownik widzi wszystkie dodane przes SIEBIE mecze.

![Example screenshot](./img/usmeczelista.jpg)

Ekran rozszerzonych informacji o danym meczu wybranym przez użytkownika.

![Example screenshot](./img/usinfomecz.jpg)

Ekran edycji meczu przez użytkownika.

![Example screenshot](./img/usedytujmecz.jpg)

Ekran, na którym uzytkownik może sprawdzić informacje o sędziach dodanych do bazy, w celu np. kontaktu z nimi w sprawie meczu.

![Example screenshot](./img/ussedziowie.jpg)

Ekran, na którym uzytkownik może sprawdzić informacje o drużynach dodanych do bazy, w celu np. kontaktu z nimi w sprawie meczu.

![Example screenshot](./img/usdruzyny.jpg)

Ekran, na którym użytkownik widzi swoje dane.

![Example screenshot](./img/usprofil.jpg)

Ekran, na którym użytkownik może edytować swoje dane.

![Example screenshot](./img/usprofiledycja.jpg)

Ekran użytkownika o roli "ADMIN" po zalogowaniu.

![Example screenshot](./img/adhome.jpg)

Ekran admina, na którym widzi mecze dodane przez wszystkich użytkowników.

![Example screenshot](./img/admecze.jpg)

Ekran, na którym admin ma możliwość edycji wybranego meczu.

![Example screenshot](./img/adedytujmecz.jpg)

Ekran, na którym admin widzi wszystkich dodanych do systemu użytkowników.

![Example screenshot](./img/adsedziowie.jpg)

Ekran, na którym admin może edytować dane uzytkowników.

![Example screenshot](./img/adedytujuzytownika.jpg)

Ekran, na którym admin widzi drużyny piłkarskie dodane do systemu.

![Example screenshot](./img/addruzyny.jpg)

Ekran, na którym admin może edytować dane drużyn będących w bazie.

![Example screenshot](./img/adedytujdruzyne.jpg)

## Status
Projekt jest: _cały czas rozwijany_. Na bieżąco dodaje kolejne funkcje i widoki oraz uaktualniam dotychczas napisany kod.



