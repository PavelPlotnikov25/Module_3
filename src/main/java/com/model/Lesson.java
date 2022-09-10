package com.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Lesson {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String code;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lector_id")
    private Lector lector;
    @OneToMany(mappedBy = "lesson")
    private Set<Grade> gradeSet;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return id.equals(lesson.id) && code.equals(lesson.code) && name.equals(lesson.name) && lector.equals(lesson.lector) && gradeSet.equals(lesson.gradeSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
