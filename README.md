# 🔗 TP — Injection des dépendances en Java

## 📌 Description

Ce projet a pour objectif de comprendre et de mettre en pratique le concept **d'injection des dépendances (Dependency Injection)** en Java.

L'objectif principal est de réaliser une application en utilisant le **couplage faible**, puis de comparer différentes méthodes d'injection des dépendances :

* 🟢 Instanciation statique
* 🔵 Instanciation dynamique avec la réflexion Java
* 🟠 Injection des dépendances avec Spring

  * Configuration XML
  * Configuration avec annotations

---

## 🎯 Objectifs du TP

Ce TP consiste à :

1. Créer une interface `IDao` contenant une méthode `getData()`.
2. Créer une implémentation de `IDao`.
3. Créer une interface `IMetier` contenant une méthode `calcul()`.
4. Créer une implémentation de `IMetier` en utilisant le **couplage faible**.
5. Réaliser l'injection des dépendances selon différentes approches :

   * Instanciation statique
   * Instanciation dynamique
   * Framework Spring avec XML
   * Framework Spring avec annotations

---

## 🏗️ Architecture du projet

Le projet est organisé selon les couches suivantes :

<img width="461" height="827" alt="image" src="https://github.com/user-attachments/assets/e1ebbc30-2b6b-4095-9528-faf669a8bc90" />


---

# 1️⃣ Création de l'interface IDao

L'interface `IDao` définit une méthode `getData()` qui sera utilisée pour récupérer une donnée.

---

# 2️⃣ Implémentation de IDao

La classe `DaoImpl` implémente l'interface `IDao`.


---

# 3️⃣ Création de l'interface IMetier

L'interface `IMetier` définit une méthode `calcul()`.

---

# 4️⃣ Implémentation avec couplage faible

La classe `MetierImpl` utilise l'interface `IDao` au lieu de dépendre directement de la classe `DaoImpl`.


### 🔍 Pourquoi utiliser `IDao` ?

On évite de faire directement :

```java
DaoImpl dao = new DaoImpl();
```

dans `MetierImpl`.

À la place, on utilise :

```java
private IDao dao;
```

Cela permet d'avoir un **couplage faible**.

Par exemple, `MetierImpl` peut fonctionner avec différentes implémentations :

```text
IDao
 │
 ├── DaoImpl
 ├── DaoImpl2
 └── DaoImpl3
```

---

# 5️⃣ Injection des dépendances

## A. 🟢 Injection par instanciation statique

Dans cette approche, les objets sont créés directement avec `new`.

### Fonctionnement

```text
        new DaoImpl()
              ↓
           IDao
              ↓
       MetierImpl
              ↓
        calcul()
```

La dépendance est injectée manuellement :

```java
metier.setDao(dao);
```

---

# B. 🔵 Injection par instanciation dynamique

Dans cette approche, les classes sont chargées dynamiquement à partir de leurs noms.

On utilise la **réflexion Java** avec :

```java
Class.forName()
```

Le fichier `config.txt` peut contenir :

```text
dao.DaoImpl
metier.MetierImpl
```

### 📌 Avantage

On peut changer l'implémentation sans modifier le code Java.

Par exemple :

```text
dao.DaoImpl
```

peut être remplacé par :

```text
dao.DaoImpl2
```

Le programme utilise alors automatiquement la nouvelle implémentation.

---

# C. 🟠 Injection avec Spring

Spring permet de gérer automatiquement les dépendances entre les objets.

On n'a plus besoin de créer manuellement les objets avec `new`.

---

## C.1 Spring avec XML

On définit les beans dans un fichier de configuration XML.

### Fonctionnement

Spring crée automatiquement :

```text
DaoImpl
   ↓
IDao
   ↓
MetierImpl
   ↓
IMetier
```

Et injecte automatiquement :

```java
setDao(dao)
```

---

# C.2 Spring avec annotations

Avec les annotations, la configuration XML devient beaucoup plus simple.

---

# 🧩 Rôle des annotations Spring

### `@Component`


`@Component` indique à Spring que la classe doit être **gérée par Spring**.

---

### `@Autowired`

`@Autowired` demande à Spring de **chercher une implémentation de `IDao` et de l'injecter** dans `MetierImpl`.

Donc :

```text
MetierImpl
    │
    │ @Autowired
    ↓
   IDao
    │
    ↓
 DaoImpl
```

---

# 📊 Comparaison des différentes méthodes

| Méthode                 | Création des objets | Configuration  | Couplage faible |
| ----------------------- | ------------------- | -------------- | --------------- |
| Instanciation statique  | `new`               | Code Java      | ✅               |
| Instanciation dynamique | Réflexion           | Fichier `.txt` | ✅               |
| Spring XML              | Spring              | XML            | ✅               |
| Spring Annotations      | Spring              | Annotations    | ✅               |

---

# 🧠 Notion importante : l'injection des dépendances

Une classe qui a besoin d'un objet dépend de cet objet.

Par exemple :

```java
MetierImpl → IDao
```

Au lieu de créer elle-même sa dépendance :

```java
DaoImpl dao = new DaoImpl();
```

on lui fournit la dépendance depuis l'extérieur :

```java
metier.setDao(dao);
```

C'est le principe de **l'injection des dépendances**.

---

# 🔄 Évolution du projet

```text
Couplage fort
     │
     ↓
DaoImpl dao = new DaoImpl();
     │
     ↓
Couplage faible
     │
     ↓
Injection manuelle
     │
     ↓
Réflexion Java
     │
     ↓
Spring XML
     │
     ↓
Spring Annotations
```

---

# Exemple d'affichage

**l'injection des dépendances Par instanciation statique version donnée**.

<img width="1315" height="214" alt="version data base" src="https://github.com/user-attachments/assets/c6a3441e-ec61-4687-96c2-82c19f413d9c" />


**l'injection des dépendances Par instanciation statique version capteur**.

<img width="1316" height="211" alt="version capteur" src="https://github.com/user-attachments/assets/62ebc95d-8300-4fd5-9a35-47e0150c921c" />


**l'injection des dépendances Par instanciation dynamique version donnée**.

<img width="1648" height="383" alt="instantation dynamique data" src="https://github.com/user-attachments/assets/36a4a48b-52a2-482a-b977-52d9968787ae" />


**l'injection des dépendances Par instanciation dynamique version capteur**.

<img width="1646" height="358" alt="instantation dynamique capteur" src="https://github.com/user-attachments/assets/dff0fd47-f803-4f4b-980c-3f3496034af9" />


---


# 🛠️ Technologies utilisées

* ☕ Java
* 🔗 Interfaces Java
* 💉 Dependency Injection
* 🔄 Java Reflection API
* 🌱 Spring Framework
* 📄 XML
* 🏷️ Spring Annotations
* 🧩 Maven 

---

# ⭐ Conclusion

Ce TP permet de comprendre progressivement le principe de **l'injection des dépendances** et l'intérêt du **couplage faible**.

On commence par une injection manuelle avec `new`, puis on évolue vers une instanciation dynamique avec la réflexion Java et enfin vers l'utilisation de **Spring**, qui automatise la création des objets et l'injection de leurs dépendances.

> **L'objectif principal est de séparer les composants et leurs dépendances afin d'obtenir une application plus flexible, maintenable et évolutive.**



