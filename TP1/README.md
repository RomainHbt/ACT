#TP1 - Diviser pour régner

* Entrées du programme:
    * l, h -> entiers > 0 : longueur et hauteur du plan
    * nbPoints -> entier >= 0 : nombre de points dans le plan
    * points[] : liste de points avec leurs coordonnées (x, y), avec 0 <= x <= l et 0 <= y <= h, triée par ordre croissant sur x

* Sortie du programme:
    * un nombre correspondant à la surface maximale d'un rectangle du plan, vérifiant les contraintes

##Question 1

* Pseudo-code:
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

* Observations at analyses : Notre algorithme est fonctionnel (il répond au problème posé), cependant, il met un certain temps à s'exécuter sur des valeurs très grandes.

##Question 2

Pour utiliser le paradigme "diviser pour régner", nous allons découper le tableau de points en 2 parties. Nous n'allons pas scinder le tableau en deux parties égales, mais à l'endroit du point le moins haut (avec y != 0). Cela va réduire le risque d'avoir un rectangle qui commence dans un tableau et fini dans l'autre.

* Pseudo-code:
    surfaceMax = 0

    

    Affichage de surfaceMax
