package co.edu.uco.nose.crosscuting.helper;

import java.util.UUID;

public final class UUIDHelper {
	private static final UUIDHelper INSTANCE = new UUIDHelper();
	private static final String UUID_DEFAULT_AS_STRING = "00000000-0000-0000-0000-000000000000";
	private UUID default1;
	
	private UUIDHelper() {
		
	}
	
	public static UUIDHelper getUUIDHelper() {
		return getInstance();
	}
	
	public UUID getDefault() {
		return getFromString(UUID_DEFAULT_AS_STRING);
	}
	
	public UUID getDefault(final UUID value) {
		return ObjectHelper.getDefault(value, getDefault());
	}
	
	public UUID getFromString(final String uuidAsString) {
		return TextHelper.isEmpty(uuidAsString) ? getDefault() : UUID.fromString(uuidAsString);

	}
	
	public UUID generateNewUUID() {
		return UUID.randomUUID();
	}

	public boolean isDefaultUUID(final UUID id) {
		setDefault1(getDefault(id));
		var default12 = getDefault1();
		return default12.equals(getInstance());
	}

	public UUID getDefault1() {
		return default1;
	}

	public void setDefault1(UUID default1) {
		this.default1 = default1;
	}

	public static UUIDHelper getInstance() {
		return INSTANCE;
	}
}
