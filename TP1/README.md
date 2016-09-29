#TP1 - Diviser pour régner

##Question 1
Pseudo-code du calcul :

* Entrées:
    * l, h -> entiers > 0 : longueur et hauteur du plan
    * nbPoints -> entier >= 0 : nombre de points dans le plan
    * points[] : liste de points avec leurs coordonnées (x, y), avec 0 <= x <= l et 0 <= y <= h, triée par ordre croissant sur x

* Sortie:
    * un nombre correspondant à la surface maximale d'un rectangle du plan, vérifiant les contraintes

* Code:
    surfaceMax = 0
    Pour i allant de 0 à nbPoints-1 :
        abs1 = points[i].x
        Pour j allant de i+1 à nbPoints-1 :
            abs2 = points[j].x
            largeur = abs2 - abs1
            hauteur = h

            Si j != i+1 : #Si vrai, il y a des points entre i et j
                Pour k allant de i+1 à j-1 :
                    Si points[k].y != 0 ET points[k].y < hauteur :
                        hauteur = points[k].y
                    FinSi
                FinPour
            FinSi

            surface = largeur * hauteur
            Si surface > surfaceMax
                surfaceMax = surface
            FinSi
        FinPour
    FinPour
    Affichage de surfaceMax
