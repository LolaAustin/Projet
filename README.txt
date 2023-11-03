a.

Pour lancer le projet : 

Avec le terminal de commande : 

Prérequis: 
	Assurez-vous d'avoir java d'installer sur votre machine, avec cette ligne de commande : 
		java -version
	Si vous avez ce message, vous pouvez continuer et suivre les étapes pour lancer le .jar. 
		java version "1.8.0_361"
		Java(TM) SE Runtime Environment (build 1.8.0_361-b09)
		Java HotSpot(TM) Client VM (build 25.361-b09, mixed mode)

Etapes: 
	- Rendez-vous dans le fichier où est contenu le .jar du projet. 
		Par exemple : cd C:\Users\s\eclipse-workspace\Efrei\s_5\Java\Projet
		Vous pouvez vérifier la présence du fichier avec l'instruction dir (Windows) ou l (Linux) 
	- Puis lancez cette ligne de commande : 
		java -jar projet.jar


Il est possible que vous rencontriez ce genre d'erreur, lors de l'execution du .jar : 
Exception in thread "main" java.lang.UnsupportedClassVersionError: exec/Start has been compiled by a more recent version of the Java Runtime (class file version 61.0), 
this version of the Java Runtime only recognizes class file versions up to 52.0
Pour pouvoir executer le .jar, il vous suffira de mettre à jour votre Java. 

b. Choix du Système de Gestion de Base de Données (SGBD) :

   Nous avons choisi MySQL Workbench dans notre cas.

c. Fonctionnalités Non Implémentées et Raisons :

   En raison de contraintes de temps, nous n'avons pas pu implémenter les fonctionnalités suivantes :

   1. Recherche de Programmeurs : Nous avons ajouté une fonction de recherche qui permet aux utilisateurs de rechercher des programmeurs par nom, prénom ou autre critère. Nous avons dû renoncer à cette amélioration par manque de temps, étant donné que nous y avons pensé trop tard.

d. Fonctionnalités Supplémentaires Ajoutées par Rapport aux Exigences Initiales :

   Nous avons ajouté quelques fonctionnalités supplémentaires par rapport aux exigences initiales définies dans les spécifications du projet :

   1. Modification de Plusieurs Champs : Les utilisateurs peuvent désormais mettre à jour plusieurs champs pour un programmeur dans l'option "Modifier l'Entrée". Ils peuvent sélectionner les champs qu'ils souhaitent mettre à jour (par exemple, salaire, nom, adresse).
   2. Afficher notre programme sous forme d'interface graphique : Cela permet une visualisation plus intuitive des informations ainsi que des choix possibles.
   3. Gestion des Erreurs : Nous avons mis en place une gestion complète des erreurs pour indiquer tout type d'incidents fréquents.

