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

