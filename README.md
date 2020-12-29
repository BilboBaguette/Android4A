# Présentation:

Voici mon projet de programmation mobile de quatrième année. Il s'agit d'une application contenant un écran de login/création de compte qui mène ensuite vers une application 
(ici affichage d'une liste avec appel à une API rest). Le tout réalisé avec MVVM/Clean Architecture.

# Installation:

## Prérequis d'Installation:

Télécharger et installer Android Studio.
Avoir à sa disposition un téléphone ou émulateur sur lequel il est possible d'installer des applications à partir d'Android Studio.

## Installation:

Récupérer la branche master sur Android Studio:

```
https://github.com/BilboBaguette/Android4A.git
```

Lancer l'application sur le téléphone/émulateur connecté à Android Studio

# Consignes Respectées:

## Consignes de base:

* Ecran de Login/Création de compte
* MVVM
* Clean Architecture
* DB Room
* Design
* Ecran avec affichage de liste par appel API

## Suppléments:

* Gitflow
* Multiple types d'erreurs de création de compte

#Présentation de l'application:

## Ecran de base:
* Ecran de Login, où l'utilisateur doit rentrer son addresse e-mail et son mot de passe, si  l'utilisateur ne dispose pas d'un compte, il en est notifié et doit en créer un.
![image](https://user-images.githubusercontent.com/44286703/103287684-7958af80-4a26-11eb-8729-c5323e669372.png)

## Ecran de création de compte:
* Lorsque l'utilsateur créé un compte, il doit rentrer une addresse e-mail valide (doit contenir @ et .) et son mot de passe, qu'il doit vérifier en le retapant. Si tous les paramètres sont valides, le compte est créé et l'utilisateur retourne à l'écran de Login.
![image](https://user-images.githubusercontent.com/44286703/103287828-d2284800-4a26-11eb-8fff-c8787a707b57.png)

## Ecran d'affichage de la liste:
Une fois que l'utilisateur s'est connecté avec son compte, il arrive sur l'écran d'affichage de la liste (ici une liste des personnages du jeu Nier:Automata).
![image](https://user-images.githubusercontent.com/44286703/103287924-0d2a7b80-4a27-11eb-8b66-05d43864daba.png)
