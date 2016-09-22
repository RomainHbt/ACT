#TP1 - Diviser pour régner

Pseudo-code du calcul :

* Entrées:
    * l, h -> entiers > 0 : longueur et hauteur du plan
    * nbPoints -> entier >= 0 : nombre de points dans le plan
    * points[] : liste de points avec leurs coordonnées (x, y), avec 0 <= x <= l et 0 <= y <= h, triée par ordre croissant sur x

* Sortie:
    * un nombre correspondant à la surface maximale d'un rectangle du plan, vérifiant les contraintes

* Code:
  largeurMax = 0
  Pour i allant de 0 à nbPoints :
    abs1 = points[i].x
    Pour j allant de i+1 à nbPoints :
      abs2 = points[j].x
      largeur = abs2 - abs1
      Pour k allant de i+1 à j :
        hauteur =  

  Affichage de largeurMax
