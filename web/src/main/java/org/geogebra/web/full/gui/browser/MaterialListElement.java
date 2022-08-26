
	private static String extractTitle(String key) {
		return key.substring(key.indexOf("_", key.indexOf("_") + 1) + 1);
	}

	/**
	 * @return true if this material is saved local
	 */
	public boolean isLocal() {
		return this.getMaterial().getId() <= 0;
	}

	/**
	 * @return true if this material belongs to the signed in user
	 */
	public boolean isOwn() {
		return this.ownMaterial;
	}

	protected void setMaterialSimple(Material material) {
		controller.setMaterial(material);
	}

	/**
	 * Actually delete the file.
	 */
	protected void onConfirmDelete() {
		controller.onConfirmDelete(this);
	}

	@Override
	public void copy() {
		controller.copy();
	}

	@Override
	public String getCardTitle() {
		return getMaterial().getTitle();
	}

	@Override
	public String getMaterialID() {
		return getMaterial().getSharingKeyOrId();
	}

	@Override
	public void updateVisibility(Material material) {
		// only needed for new cards
	}
}