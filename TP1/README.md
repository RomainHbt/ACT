#TP1 - Diviser pour régner

##Question 1

###Méta-données

* Entrées du programme:
    * l, h -> entiers > 0 : longueur et hauteur du plan
    * nbPoints -> entier >= 0 : nombre de points dans le plan
    * points[] : liste de points avec leurs coordonnées (x, y), avec 0 <= x <= l et 0 <= y <= h, triée par ordre croissant sur x

* Sortie du programme:
    * un nombre correspondant à la surface maximale d'un rectangle du plan, vérifiant les contraintes

###Pseudo-code

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

			Si surface > surfaceMax :
				surfaceMax = surface
			FinSi
		FinPour
	FinPour
	Affichage de surfaceMax
	
###Observations at analyses
Notre algorithme est fonctionnel (il répond au problème posé), cependant, il met un certain temps à s'exécuter sur des valeurs très grandes.

##Question 2

Pour utiliser le paradigme "diviser pour régner", nous allons découper le tableau de points en 2 parties. Nous n'allons pas scinder le tableau en deux parties égales, mais à l'endroit du point le moins haut (avec y != 0). Cela va réduire le risque d'avoir un rectangle qui commence dans un tableau et fini dans l'autre.

Nous allons pour cette partie, utiliser un objet java Point pour symboliser un point, afin qu'il soit plus simple de récupérer les informations d'un point.

###Méta-données

* Entrées du programme:
	* l, h -> entiers > 0 : longueur et hauteur du plan
    * points -> liste de points
    * indexGauche -> index du sous-tableau de la partie gauche
    * indexDroit -> index du sous-tableau de la partie gauche

* Sortie du programme:
    * un nombre correspondant à la surface maximale d'un rectangle du plan, vérifiant les contraintes

###Pseudo-code:
    Instanciation de liste de points : partieGauche et partieDroite
	
	Si indexDroite - indesGauche > 0 et que la liste de points n'est pas vide :
		hauteurMin = h
		pointDeSeparation = 0

		Pour i allant de 0 à nbPoints :
			Si points[i].y != 0 et que points[i].y < hauteurMin :
				hauteurMin = points[i].y
				pointDeSeparation = i
			FinSi
		FinPour

		surface = (indexDroite - indexGauche) * hauteurMin

		Si pointDeSeparation > 0
			partieGauche = points[0 ... pointDeSeparation]
		FinSi

		Si pointDeSeparation < nbPoints
			partieDroite = points[pointDeSeparation + 1 ... nbPoints]
		FinSi

		newSurface = max(
			calcul(partieGauche, indexGauche, points[pointDeSeparation].x),
			calcul(patieDroite, points[pointDeSeparation].x, indexDroite)
		)

		Renvoyer max(surface, newSurface);

	Sinon :
		Renvoyer 0
	Fin Si


###Observations at analyses

On remarque qu'avec la méthode "Diviser pour régner", on réduit considérablement le temps de calcul pour atteindre notre objectif, comparé au script de la question 1.
