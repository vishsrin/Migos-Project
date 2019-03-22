import java.util.ArrayList;
public class POStoWord {
      private String path ="/Users/adityadhir/Desktop/";
      private  ArrayList<String> adjectives;
      private ArrayList<String> adlibs;
      private  ArrayList<String> articles;
      private  ArrayList<String> conjunctions;
      private  ArrayList<String> negatives;
      private  ArrayList<String> nouns;
      private  ArrayList<String> prepositions;
      private  ArrayList<String> pronouns;
      private  ArrayList<String> propernouns;
      private  ArrayList<String> verbs;
      private ArrayList<String> adverbs;
        
        public POStoWord() throws Exception {
           adjectives = (new filetoArrayList(path + "Adjectives.txt")).getArrayList();
           adlibs = (new filetoArrayList(path + "Adlibs.txt")).getArrayList();
           articles = (new filetoArrayList(path + "Articles.txt")).getArrayList();
           conjunctions = (new filetoArrayList(path + "Conjunctions.txt")).getArrayList();
           negatives = (new filetoArrayList(path + "Negatives.txt")).getArrayList();
           nouns = (new filetoArrayList(path + "Nouns.txt")).getArrayList();
           prepositions = (new filetoArrayList(path + "Prepositions.txt")).getArrayList();
           pronouns = (new filetoArrayList(path + "Pronouns.txt")).getArrayList();
           propernouns = (new filetoArrayList(path + "Propernouns.txt")).getArrayList();
           verbs = (new filetoArrayList(path + "Verbs.txt")).getArrayList();
        }
        
        public String getWord(String type) {
          switch(type.toLowerCase()) {
            case "adjective":
              return adjectives.get((int) Math.random() * adjectives.size());
            case "adverb":
              return adverbs.get((int) Math.random() * adverbs.size());
            case "adlib":
                return adlibs.get((int) Math.random() * adlibs.size());
            case "preposition":
                return prepositions.get((int) Math.random() * prepositions.size());
            case "article":
                return articles.get((int) Math.random() * articles.size());
            case "conjunction":
                return conjunctions.get((int) Math.random() * conjunctions.size());
            case "pronoun":
                return pronouns.get((int) Math.random() * pronouns.size());
            case "negative":
                return negatives.get((int) Math.random() * negatives.size());
            case "noun":
                return nouns.get((int) Math.random() * nouns.size());
            case "verb":
                return verbs.get((int) Math.random() * verbs.size());
            case "propernoun":
                return propernouns.get((int) Math.random() * propernouns.size());
            default:
              return type;
          }
        }  

}