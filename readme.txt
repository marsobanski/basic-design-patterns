Wzorce projektowe (dobra strona: https://refactoring.guru/design-patterns):
* kreacyjne
    * Buiilder
    * Factory
    * Singleton
* strukturalne
    * Adapter
    * Decorator
    * Flyweight
* behawioralne
    * Chain of responsibility
    * Command
    * Memento
    * Template method
    * Strategy
    * Observer


Observer:
    * kiedy uzywać?
        * kiedy zmiana stanu obiektu może wymagać zmiany innego obiektu,
            jednak zbiór tych obiektów jest z początku nieznany lub się dynamicznie zmienia
    * problem:
        * jeżeli chcemy powiadamiać o zmianie stanu jakiegoś obiektu (np. Zamówienia), możemy to robić różnymi kanałami (np. SMS, Email)
            jednak chcemy mieć kontrolę nad tym jakie obiekty wysyłają zminy stanu jakimi kanałami
    * rozwiązanie:
        * tworzymy obiekty (Observable) i kanały (Observer)
        * w kanałach są metody powiadamiania o stanie dla obiektów
        * w obiektach są metody dodawania i usuwania kanałów z listy kanałów oraz metody powiadomienia i zmiany stanu (ona zawiera
    * info:
        * w metodzie Observer#changeOrderStatus znajduje się metoda Observer#notify,
            dzięki czemu przy zmianie stanu zawsze zostaną powiadomieni odpowiedni obserwatorzy
        * w java.util jest Observer, ale Observable jest klasą, więc jest mniej elastyczne
    * schemat i info: https://refactoring.guru/design-patterns/observer

Singleton:
    * do użytku kiedy można mieć zawsze dokładnie jedną instancję danej klasy;
    * klasa zawiera:
        * prywatny konstruktor
        * prywatne statyczne pole instance typu takiego jak klasa
        * pubkiczną statyczną metodę getInstance(), która zwraca instance lub, jeśli instance == null, nowy obiekt klasy
    * potencjalne problemy:
        * wielowątkowość
            * problem - dwa wątki wywołują getInstance
                * jeden sprawdza, że jest nullem, więc ma utworzyć nową instancję
                * drugi sprawdza czy jest nullem zanim pierwszy utworzy instancję
                * obydwa tworzą nową instancję
            * zapobieganie na 3 sposoby:
                * metoda getInstance() synchroniczna
                    * minus - w metodzie będzie mógł przebywać jeden wątek, inne czekają
                * podwójny check (stworzenie drugiego sprawdzenia w bloku synchronicznym) - sprawdź klasę GameEngine
                * tworzenie nowego obiektu od razu przy polu instance - sprawdź klasę GameEngine (najlepsze)
        * serializacja
            * problem - jeśli singleton musi być serializowany, to w dowolnym momencie ktoś może singletona serializować,
                a potem odserializować dowolną ilość kopii, więc znów mamy wiele instancji
            * zapobieganie:
                * stworzyć metodę readResolve(), wywoła się za każdym razem, kiedy obiekt klasy będzie odserializowany
        * refleksje
            * problem - ktoś za pomocą relfeksji będzie grzebał w naszej klasie, np. zrobi publiczny konstruktor
            * rozwiązanie (nie ma ładnej ochrony, jest hax):
                * zaimplementować singleton jako enum (patrz GameEngineEnum)
                * jeśli konstruktor enuma ma parametry, to trzeba je przekazać podczas tworzenia instancji
                * enumy są zabezpieczone przed wielowątkowością, serializacją i refleksjami, enum w ogóle jest singletonem,
                    ale jest to mało intuicyjne
        * class loader
            * singleton zapewnia jedną instancję klasy dla jednego class loadera
                * jeżeli korzystamy z >1 class loadera, wtedy każdy będzie miał swoją instancję, ale najlepiej nie robić >1 class loadera,
                    ale jak trzeba, to trzeba to jakoś rozwiązać :P


