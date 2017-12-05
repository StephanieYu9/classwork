package lightsOut;

private class StartGameListener implements ActionListener {

    public void actionPerformed(ActionEvent evt) {
      model = new LightsOut();
      model.setRandomLights(5);
      setColors();

    }
  }