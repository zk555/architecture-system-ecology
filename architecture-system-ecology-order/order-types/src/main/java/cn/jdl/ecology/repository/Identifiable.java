package cn.jdl.ecology.repository;

public interface Identifiable<ID extends Identifier> {
    ID getId();
}
