package domain.MedicalCasse;

import java.util.UUID;

public class Option {
    private UUID optionId; // not null
    private String description; // not null

    public Option(String description) {
        this.optionId = UUID.randomUUID();
        this.description = description;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public UUID getOptionId() {
        return optionId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Option option = (Option) o;
        return optionId.equals(option.optionId);
    }


    @Override
    public int hashCode() {
        return optionId.hashCode();
    }
}