package edu.kata.task312.entity.parent;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public abstract class NameEntity extends BaseEntity {

    private String name;
}
