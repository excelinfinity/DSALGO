package edu.advancedatastructure;/*
 @author Vaibhav Agrawal<vaibhavagrawaliitr.gmail.com>
 @date 28'April,2018()
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
class Entity<K,V>{
    private K key;
    private V value;
    Entity(K k,V v){
        key = k;
        value = v;
    }
    K getKey(){
      return key;
    }
    V getValue(){
        return value;
    }
}
class LinkList {
    private Node head;
    class Node{
        Node next;
        Entity value;
    }
    LinkList(Entity entity){
        head = new Node();
        head.value = entity;
    }
    LinkList(){
        head = null;
    }
    void addNode(Entity value){
        Node next = new Node();
        next.value = value;
        next.next = head;
        head = next;
    }
    Entity getNode(Entity entity){
        Node node = head;
        while(node!=null){
            if(node.value.getKey()==entity.getKey()){
                return node.value;
            }
            node  = node.next;
        }
        return null;
    }
}
class HashMapADT{
    private LinkList [] arr;
    private Integer CONST = 37;
    HashMapADT(){
        arr = new LinkList[CONST];
    }
    void put(Entity e){
        int index = Math.abs(getIndex(e));
        if(arr[index]==null){
            LinkList newList = new LinkList(e);
            arr[index] = newList;
        }else{
            LinkList newList = arr[index];
            newList.addNode(e);
            arr[index] = newList;
        }
    }

    Entity get(Entity entity){
        int index = getIndex(entity);
        if(arr[index]!=null){
            LinkList lnkList = arr[index];
            return lnkList.getNode(entity);
        }
        return null;
    }
    private int getIndex(Entity e){
        int index = e.getKey().hashCode();
        return index%CONST;
    }
}
public class CustomHashMap {
    public static void main(String... str) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        HashMapADT map = new HashMapADT();
        Entity<String,String> e1 = new Entity("vaibhav","mad over programming");
        Entity<String,String> e2 = new Entity("aditya","love bulk framework");
        Entity<String,String> e3 = new Entity("abcd","something random");
        Entity<String,String> e4 = new Entity("xyz","I don't know");
        map.put(e1);
        map.put(e2);
        map.put(e3);
        map.put(e4);
        Entity e = new Entity("xyz","");
        Entity getEntity = map.get(e);
        if(getEntity==null) System.out.println("Key not found");
        else System.out.println(getEntity.getKey() + "  " + getEntity.getValue());
    }
}
