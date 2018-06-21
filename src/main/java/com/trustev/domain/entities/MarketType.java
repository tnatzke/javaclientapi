package com.trustev.domain.entities;

import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.deser.StdDeserializer;

@JsonDeserialize(using = MarketType.MarketTypeDeserializer.class)
public enum MarketType {

    Default(0), UnsecuredPersonalLoans(1), CreditCards(2), MultiFamilyRentalScreening(3), AutoLending(4), ShortTermAlternativeLending(5), TelecomAndCommunications(6), Insurance(7), Mortgage(8);
	
	private int numVal;
	
	MarketType(int numVal)
	{
		this.numVal = numVal;
	}
	
	public int getNumVal()
	{
		return this.numVal;
	}

	public static class MarketTypeDeserializer extends StdDeserializer<MarketType> {
		public MarketTypeDeserializer() {
			super(MarketType.class);
		}

		@Override
		public MarketType deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException{
			final JsonNode jsonNode = jp.readValueAsTree();

			MarketType type;
			int valueNum = jsonNode.asInt();

			switch(valueNum)
			{
				case 0:
					type = MarketType.Default;
					break;
				case 1:
					type = MarketType.UnsecuredPersonalLoans;
					break;
				case 2:
					type = MarketType.CreditCards;
					break;
				case 3:
					type = MarketType.MultiFamilyRentalScreening;
					break;
				case 4:
					type = MarketType.AutoLending;
					break;
				case 5:
					type = MarketType.ShortTermAlternativeLending;
					break;
				case 6:
					type = MarketType.TelecomAndCommunications;
					break;
				case 7:
					type = MarketType.Insurance;
					break;
				case 8:
					type = MarketType.Mortgage;
					break;
				default:
					return null;
			}

			return type;
		}
	}
}
