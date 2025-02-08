package org.example.action;

public interface MovedI<T,K> {
   void setPositionObject();
   T makeMove();
   K  deletedObject();
   void spawnObject();
}
