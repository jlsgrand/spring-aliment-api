# Exemple d'implémentation d'API REST

La lecture (**R** du **CRUD**) permet de lire des collections d'entités. Dès qu'il y a un volume conséquent de données,
on voudra permettre de récupérer des données :
  * par *pages*
  * triées
  
## API REST

Au niveau de la requête, on va considérer qu'une page n'a pas d'existence propre et n'a donc pas d'URI dédiée, mais
correspond à un paramétrage de l'URI d'accès à la collection de l'ensemble des entités. Ce paramétrage indique :
  * la taille des pages (combien d'entités par page)
  * le numéro de page (attention : indice commençant à 0 ou à 1 ?)
  
L'ordre correspond lui aussi à un paramétrage déterminé par un ou plusieurs :
 * attribut de l'entité (e.g. nom, prix, popularité,…)
 * direction ascendant ou descendante (e.g. tri par prix croissants ou décroissants)
 
 On utilisera l'interface [Page](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/domain/Page.html)
 pour représenter une page et l'interface [Sort](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/domain/Sort.html)
 pour représenter les ordres (façons de trier) dans le framework *Spring*
 
##  JPA

Au niveau *JPA*, on utilise l'interface [PagingAndSortingRepository](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/PagingAndSortingRepository.html)
(ou [une interface dérivée](https://www.baeldung.com/spring-data-repositories) ).

# TODO

## Tester l'interface avec Swagger

En utilisant l'URL http://localhost:8080/swagger-ui.html .
Celle-ci est générée grâce aux annotations comme [@ApiParam](http://docs.swagger.io/swagger-core/v1.5.0/apidocs/io/swagger/annotations/ApiParam.html).

## Paramètres par défaut de la pagination

Utiliser l'annotation [PageableDefault](https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/web/PageableDefault.html) pour gérer les valeurs par défaut de pagination.

## Tri

Essayer de généraliser le code qui gère l'ordre de tri.

# Pour aller plus loin …

Au delà de REST, on pourrait vouloir implémenter [HATEOAS](https://fr.wikipedia.org/wiki/HATEOAS) avec notamment les liens vers les pages suivante et précedente d'une page donnée.
La bibliothèque [spring-hateoas](https://spring.io/projects/spring-hateoas) met à disposition un framework pour réaliser une telle implémentation.
