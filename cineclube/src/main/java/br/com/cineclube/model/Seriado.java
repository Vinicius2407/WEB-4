package br.com.cineclube.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Seriado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    @NotNull
    @Past(message = "Nao aceita data Futura")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate release;

    @NotNull
    private Category category;

    @Min(message = "Deve ser um Valor maior ou igual a 0", value = 0)
    @Max(message = "Deve ser um valor menor ou igual a 10", value = 10)
    @NotNull
    private BigDecimal score;

    @NotBlank
    private String title;

    private Integer numberOfEp;

    private Integer numberOfSeason;

    public Seriado() {
    }

    public Seriado(String title, Integer numberOfEp, Integer numberOfSeason, Category category,
            BigDecimal score, LocalDate release) {
                this.title = title;
                this.numberOfEp = numberOfEp;
                this.numberOfSeason = numberOfSeason;
                this.category = category;
                this.score = score;
                this.release = release;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getRelease() {
        return release;
    }

    public void setRelease(LocalDate release) {
        this.release = release;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNumberOfEp() {
        return numberOfEp;
    }

    public void setNumberOfEp(Integer numberOfEp) {
        this.numberOfEp = numberOfEp;
    }

    public Integer getNumberOfSeason() {
        return numberOfSeason;
    }

    public void setNumberOfSeason(Integer numberOfSeason) {
        this.numberOfSeason = numberOfSeason;
    }

    //?
}