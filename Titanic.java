
public class Titanic {

    public enum Attribute {
        NAME,
        PORT,
        CLASS,
        SEX,
        AGE,
        SIBLINGS,
        PARENTS,
        FARE
    }

    public enum Sex   { MALE, FEMALE, UNKNOWN }
    public enum Class { FIRST, SECOND, THIRD, UNKNOWN }
    public enum Port  { CHERBOURG, QUEENSTOWN, SOUTHAMPTON, UNKNOWN }

    public static class Passenger {

        private int     id;
        private String  name;
        private Port    port;
        private Class   pclass;
        private Sex     sex;
        private double  age;
        private int     siblings;
        private int     parents;
        private double  fare;
        private Boolean survived;

        public Passenger(
                int     id,
                String  name,
                Boolean survived,
                Port    port,
                Class   pclass,
                Sex     sex,
                double  age,
                int     siblings,
                int     parents,
                double  fare)
        {
            this.id       = id;
            this.name     = name;
            this.survived = survived;
            this.port     = port;
            this.pclass   = pclass;
            this.sex      = sex;
            this.age      = age;
            this.siblings = siblings;
            this.parents  = parents;
            this.fare     = fare;
        }

        public int     id()       { return this.id; }
        public String  name()     { return this.name; }
        public Boolean survived() { return this.survived; }
        public Port    port()     { return this.port; }
        public Class   pclass()   { return this.pclass; }
        public Sex     sex()      { return this.sex; }
        public double  age()      { return this.age; }
        public int     siblings() { return this.siblings; }
        public int     parents()  { return this.parents; }
        public double  fare()     { return this.fare; }

        public boolean missing(Attribute attribute) {
            // Determines if the data for this attribute is missing for this passenger.
            switch(attribute) {
                case NAME:     return this.name.isEmpty();
                case CLASS:    return this.pclass == Class.UNKNOWN;
                case PORT:     return this.port == Port.UNKNOWN;
                case SEX:      return this.sex == Sex.UNKNOWN;
                case AGE:      return this.age < 0.0;
                case SIBLINGS: return this.siblings < 0;
                case PARENTS:  return this.parents < 0;
                case FARE:     return this.fare < 0.0;
            }
            throw new IllegalArgumentException("Invalid attribute: " + attribute);
        }

        public double get(Attribute attribute) {
            // Returns the value of the specified attribute for this passenger.
            switch(attribute) {
                case CLASS:    return this.pclass.ordinal();
                case PORT:     return this.port.ordinal();
                case SEX:      return this.sex.ordinal();
                case AGE:      return this.age;
                case SIBLINGS: return this.siblings;
                case PARENTS:  return this.parents;
                case FARE:     return this.fare;
            }
            throw new IllegalArgumentException("Invalid attribute: " + attribute);
        }


    }
}


