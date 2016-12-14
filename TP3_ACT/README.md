# ACT - TP 3

HEMBERT Romain  
MAGY Alessandro  
M1S1 - Groupe 3

## 1 - Qu’est-ce qu’une propriété NP ?

Q1) Un certificat est la répartition des objets dans les sacs. On peut l'implémenter avec plusieurs listes d'objets, une pour chaque sac, pour avoir un certificat.

La taille du certificat est bornée polynomialement car le nombre d'objet du certificat et le nombre d'entrées sont égaux.

-----------------

Q2.1) Pour chaque objet, on tire au hasard un sac, et on met l'objet dans ce sac. Si on répète ce procédé un grand nombre de fois, on peut générer énormément de certifiats (bon ou mauvais), qui ont tous la même probabilité de sortir.

Q2.2) D'abord on génère un certificat aléatoirement, ensuite on vérifie s'il correspond aux critères.

-----------------

Q3.1) k^n

Q3.2) /

Q3.3) /

## 2 - Réductions polynomiales

### Une première réduction très simple

Q5) Le problème *Partition* peut être réduit en problème *BinPack* car on pourrait utiliser 2 sacs de taille : Somme(xi)/2

Q5.2) On sait que :

* Un problème NP-Dur est forcément un problème NP
* Partition est NP-Dur (car NP-Complète)
* Partition est réduit en BinPack

Or si une propriété NP-Dur se réduit en une autre propriété, cette dernière est aussi NP-Dur.

Donc BinPack est NP-Dur.

Q5.3) Oui, car Partition est NP-Complete

### Une réduction un peu moins évidente

Q6) Partition est un cas particulier de Sum. C = Somme(xi)/2

### Composition de réductions

Q8) Tout d'abord on réduit Sum en Partition, puis en BinPack.