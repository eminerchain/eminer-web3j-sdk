package com.em.sdk.core.protocol.core.methods.response;

import com.em.sdk.core.protocol.ObjectMapperFactory;
import com.em.sdk.utils.Numeric;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectReader;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Objects;

import lombok.Data;

public class EMAssetInfo {

    @Data
    public static class AssetInfo {
        /**
         * asset name
         */
        private String name;
        /**
         * the short name of asset
         */
        private String symbol;

        /**
         * the total supply of asset, the unit is wei
         */
        private String supply;
        /**
         * the description of asset
         */
        private String desc;


        public AssetInfo() {
        }

        public AssetInfo(String name, String symbol, String supply, String desc) {
            this.name = name;
            this.symbol = symbol;
            this.supply = supply;
            this.desc = desc;
        }

        @Override
        public boolean equals(Object o) {

            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            EMAssetInfo.AssetInfo assetInfo = (EMAssetInfo.AssetInfo) o;
            return name.equals(assetInfo.name) && symbol.equals(assetInfo.symbol) && supply.equals(assetInfo.supply) &&
                   desc.equals(assetInfo.desc);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, symbol, supply, desc);
        }


        public BigInteger getSupply() {
            return Numeric.decodeQuantity(supply);
        }


    }

    public static class ResponseVoteDeserialiser extends JsonDeserializer<AssetInfo> {

        private ObjectReader objectReader = ObjectMapperFactory.getObjectReader();

        @Override
        public EMAssetInfo.AssetInfo deserialize(
            JsonParser jsonParser,
            DeserializationContext deserializationContext) throws IOException {
            if (jsonParser.getCurrentToken() != JsonToken.VALUE_NULL) {
                return objectReader.readValue(jsonParser, EMAssetInfo.AssetInfo.class);
            } else {
                return null;  // null is wrapped by Optional in above getter
            }
        }
    }
}
