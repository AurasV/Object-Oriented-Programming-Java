public class Main {
    public static void main(String[] args) {
        EmergencyQueue queue = new EmergencyQueue(10);

        // make distressed people, can be as many as wanted, used ten due to exercise requirement
        for (int i = 0; i < 10; i++) {
            new DistressedPerson(queue, "Caller " + i, "Location " + i, "Description " + i).start();
        }

        // make dispatchers, can be as many as wanted, used three for speed
        for (int i = 0; i < 3; i++) {
            new Dispatcher(queue).start();
        }

        // as of right now, the program stops when the queue processed maxsize emergencies
        // it's not the most elegant way due to the way it just... exits, but it works for now,
        // if that is excluded the program will run forever waiting for more emergencies which is
        // more like what it would be like in the real world.
        // also due to the speed / the way java threads work, sometimes
        // higher urgency emergencies will be processed after lower urgency emergencies
        // this only happens when there's multiple dispatchers, with one dispatcher it works perfectly.
        // the logging is so extensive due to debugging, it also helps to understand what's going on,
        // so I left it in
    }
}
