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


Builder:
    * do tworzenia obiektów:
        * kiedy jest sporo pól w klasie (np. House), to zamiast robić pierdyliar konstruktorów, robimy klasę Builder (np. HouseBuilder),
            w niej metody na ustawianie wszystkich pól, ale każda zwraca obiekt klasy House, więc budujemy obiekt w łańcuchu metod
        * dwa sposoby:
            * klasa wewnętrzna
                * w klasie House tworzymy public static class HouseBuilder
                * HouseBuilder ma takie same pola jak House
                * House ma jeden prywatny konstruktor z parametrem HouseBuilder
                    i ustawia pola na zasadzie 'this.widnows = houseBuilder.walls'
                * HouseBuilder ma metodę build(), która zwraca new House(this) i metody ustawiające pola w łańcuchu
            * klasyczny:
                * interfejs HouseBuilder oraz jego implementacje SmallHouseBuilder i BigHouseBuilder, gdzie będą implementacje
                * klasa HouseDirector, w której możemy na sztywno ustawić jakąś logikę budowania obiektów, kiedy nie chcemy, żeby potem
                    ktoś nie miał za dużo wolności w budowaniu obiektów
        * na refactoring guru jest trochę inaczej niż w moim przykładzie, bo tu na sztywno wpisane są rzeczy w implementacjach builderów
            i tam jest podkreślone, że Director może mieć w miarę sztywne metody budowy do reużycia, ale cóż


Factory:
    * do tworzenia obiektów poprzez delegowanie tworzenia do klasy Factory, zamiast tworzyć za pomocą konstruktora.
        Pozwala to na tworzenie kolejnych implementacji Factory do tworzenia kolejnych implementacji obiektu bazowego
    * dwa rodzaje:
        * metoda fabrykująca:
            * abstrakcyjna klasa Unit i dziedziczące po niej klasy Rifleman i Tank (albo interfejsy zamiast dziedziczenia)
            * klasa abstrakcyjna Factory oraz dziedzicząca UnitFactory
                * w Factory jest metoda create(), która tworzy obiekt Unit, wtedy w UnitFactory można
                    zdefiniować tworzenie różnych implementacji obiektów klasy Unit (Tank, Rifleman)
        * abstract factory
            * przydatne kiedy potrzebujemy mieć wiele implementacji obiektu Unit, które różnią się cechami
                * na przykład tworzymy dwie strony konfliktu i więcej typów (bo to wygląda jak z jakiejś gry wojennej te klasy)
                    i nagle mamy Unit -> InfantryUnit -> Rifleman i dla każdej strony tworzymy inaczej te jednostki, a więc
                    InfantryUnitFactory -> BlueInfantryFactory, więc się sporo klas tworzy i ciężko to ogarnąć,
                    a jakby dorzucić jeszcze statki, to potrzeba jeszcze więcej klas, więc trochę klops
                * zmiana jest taka, że:
                    * abstrakcyjną Factory rozszerzana przez BlueFactory i RedFactory
                    * mamy abstrakcyjne InfantryUnit i MechanizedUnit
                    * blue Tank i Rifleman są tworzone w BlueFactory, a obydwa red w RedFactory (nie ma klas BlueTank, tylko tak napisałem, jest Tank)
                    * klasy Tank i Rifleman, które rozszerzają InfantryUnit i MechanizedUnit
                    * jeżeli dojdą statki:
                        * dorabiamy klasę WaterUnit, którą będą rozszerzały np. Destroyer i Carrier
                        * dodajemy w RedFactory i BlueFactory klasy createWaterUnit i



