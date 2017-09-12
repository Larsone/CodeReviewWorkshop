import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


/**
 * This code reads a file and checks if each line has an ending from a list,
 * it then sends the it to Kafka if it does!
 * @author me
 * @created 2017/09/12
 */
public class FileChecker {


    public String check_against_file(String a) throws IOException {
        File f = new File("data.txt");

        BufferedReader b = new BufferedReader(new FileReader(f));





        System.out.println("Reading file using Buffered Reader");

        String _59998r = "nope"; // The return value
        String l; //The line I'm reading

        while ((l = b.readLine()) != null) if (l.endsWith(a)) _59998r = "yep"; //Sets return to yep

//        if (l.endsWith("once")) {
//            r = "yep";
//        } else if (l.endsWith("twice")) {
//            r = "yep"
//        }

        return _59998r;

    }

    public void HOWMANYTIMESARETHESEWORDSINAFILE() throws IOException{
        //If the program manger changes their mind again this is what you change
        String[] ListOfThingsIWantToCheck= {
                "once",
                "twice",
                "thrice"
        };
        for (String a_single_item_in_my_list_of_things_i_want_to_check : ListOfThingsIWantToCheck) {
            String response_from_my_checking_function = check_against_file(a_single_item_in_my_list_of_things_i_want_to_check);
            if (response_from_my_checking_function.equals("yep")) {
                System.out.println("A file has " + a_single_item_in_my_list_of_things_i_want_to_check);
                // Send the match to Kafka
                sendMyYepsToKafka(response_from_my_checking_function);
            } else if (response_from_my_checking_function.equals("nope")){
                System.out.println("A file doesn't have " + a_single_item_in_my_list_of_things_i_want_to_check);
            } else {
                System.out.println("Don't know how you got here lolololololololololol XD");
            }
        }
    }

    /**
     * Take a match from the file and add it to Kafka
     * @param yeps - The matched String from the file
     */
    private void sendMyYepsToKafka(String yeps) {
        KafkaProducer<String, String> kafkaaaaaaaaaaaaaa = producer();
        // TODO: change keys
        ProducerRecord<String, String> record = new ProducerRecord<String, String>("test-topic", "key-" + yeps, "message-"+yeps);
        kafkaaaaaaaaaaaaaa.send(record);
    }

    // Code stops working if you change this, not sure why :s
    private KafkaProducer<String, String> producer(){
        return new KafkaProducer<String, String>(MyProperties.getProperties());
    }

    public static void main(String[] args) {
        FileChecker fileChocker = new FileChecker();
        try {
            fileChocker.HOWMANYTIMESARETHESEWORDSINAFILE();
        } catch (Exception e) {
            //This should never happen
        }
    }

}
