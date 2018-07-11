package com.icodici.universa.contract.services;

import com.icodici.crypto.KeyAddress;
import com.icodici.universa.HashId;
import net.sergeych.biserializer.BiDeserializer;
import net.sergeych.biserializer.BiSerializable;
import net.sergeych.biserializer.BiSerializer;
import net.sergeych.tools.Binder;
import net.sergeych.tools.Do;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Implements {@link ContractStorageSubscription} interface for slot contract.
 */
public class NNameRecordEntry implements NameRecordEntry,BiSerializable {

    private long id = 0;
    private long nameRecordId = 0;
    private HashId origin;
    private String longAddress;
    private String shortAddress;

    public NNameRecordEntry() {

    }

    public NNameRecordEntry(HashId origin, String shortAddress, String longAddress) {
        this.origin = origin;
        this.longAddress = longAddress;
        this.shortAddress = shortAddress;
    }

    @Override
    public String getLongAddress() {
        return longAddress;
    }

    @Override
    public String getShortAddress() {
        return shortAddress;
    }

    @Override
    public HashId getOrigin() {
        return origin;
    }

    public long getNameRecordId() {
        return nameRecordId;
    }

    public void setNameRecordId(long nameRecordId) {
        this.nameRecordId = nameRecordId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public Binder serialize(BiSerializer serializer) {
        Binder data = new Binder();
        data.set("origin", serializer.serialize(origin));
        data.set("shortAddress", serializer.serialize(shortAddress));
        data.set("longAddress", serializer.serialize(longAddress));

        return data;
    }

    @Override
    public void deserialize(Binder data, BiDeserializer deserializer) {
        try {origin = deserializer.deserialize(data.get("origin"));} catch (Exception e) {origin = null;}
        shortAddress = data.getString("shortAddress",null);
        longAddress = data.getString("longAddress",null);

    }
}
