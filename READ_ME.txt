Pour toutes questions sur le fonctionnement du code n'hésitez pas à nous contacter.


Organisation du code :


---Les actions---

Pour créer une nouvelle action il faut ajouter une nouvelle classe qui hérite de Action dans le package action. 
-La méthode act() doit réaliser l'action et donc retourner un String qui sera directement interprété par le simulateur (donc pas par notre code).
-La méthode read(String , Action act) sera appelée le tour après que act() ait été appelée . Elle sert à mettre à jour nos données en fonction de ce qu'elle recevra en paramètres par le simulateur. Exemple : mettre à jour les pa utilisés, les ressources récoltées.
Le 2ème paramètre de read sert à avoir accès aux données de notre robot pour les modifier.

Pour utiliser une nouvelle action il faut par contre modifier directement le code. La décision finale est prise dans la classe Simulator, nous allons voir plus en détail le fonctionnement du choix de la décision.

---Classe Simulator & Arena---

-Dans la classe Simulator se trouve toutes les données de notre robot et c'est ici que son comportement est définit. Le choix se fait au sein de la méthode getNextDecision(). Cette même méthode gère tout sauf le choix d'une nouvelle direction en cas de déplacement, scout ou glimps.
En effet à partir du moment où notre méthode getNextDecision() estime qu'il faut réaliser une action vers une autre case (Tuils dans notre code) que celle où on se trouve.

-La classe Arena va donc gérer le choix des actions scout/glimps/move_to en fonction de ce qu'il se trouve sur les cases adjacentes et les objectifs à rapporter. Cela se fait essentiellement au sein de la méthode BestD() qui renvoit un tableau de String qui contient l'action choisi et la direction.

---Character1---
Cette classe gère les pa et les objectifs.

---Pos---
Cette classe sert à définir une position à une Tuil et au robot.

---Contract---
Cette classe n'est pas encore implémentée dans le code elle a été créé afin d'ajouter une gestion optimale des contrats.

---Ressource---
Gère toutes les ressources (pas besoin de créer une nouvelle classe si on veut ajouter une nouvelle ressource par contre si on veut un traitement particulier pour cette ressource pour le choix des objectif cela se fait dans read() de la classe Action.
estimCost() n'est pas utilisée, elle pourrait servir à améliorer la gestion des contrats.

---Explorer---
C'est la seule classe qui sera utilisée par le championnat. Le championnat appelle une fois la méthode initialize() puis à tour de rôle les méthodes takeDecision() et acknowledgeResults(). Dans takeDecision() sera grosso modo appelé la méthode act() de l'action qui sera fait, et dans acknowledgeResults() sera appelé read(). (c'est délégué à notre classe simul()).




Pistes d'améliorations pour le problème sur les objectifs secondaires :

Comme les ressources qui peuvent être en objectifs sont connues à l'avance, faire un tableau de toutes les ressources int[8]. Chaque case correspond à une ressource et si on cherche une ressource primaire on passe la case du tableau correspondante à 1. Celà évitera la duplication d'objectifs pour la même chose ce qui est à l'origine de notre bug.




