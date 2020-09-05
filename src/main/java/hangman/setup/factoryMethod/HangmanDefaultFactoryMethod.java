package hangman.setup.factoryMethod;

import hangman.model.*;
import hangman.model.Language;
import hangman.model.dictionary.FrenchDictionaryDataSource;
import hangman.model.dictionary.HangmanDictionary;
import hangman.view.HangmanPanel;
import hangman.view.HangmanStickmanPanel;

import com.google.inject.Guice;
import com.google.inject.Injector;
import hangman.GUI;
import hangman.model.GameScore;
import hangman.model.OriginalScore;
import hangman.setup.guice.HangmanFactoryServices;

public class HangmanDefaultFactoryMethod extends HangmanFactoryMethod {
    @Override
    public Language createLanguage() {
        Injector injector = Guice.createInjector(new HangmanFactoryServices());
        return injector.getInstance(Language.class);

    }

    @Override
    public HangmanDictionary createDictionary() {
        Injector injector = Guice.createInjector(new HangmanFactoryServices());
        return injector.getInstance(HangmanDictionary.class);
    }

    @Override
    public HangmanPanel createHangmanPanel() {
        Injector injector = Guice.createInjector(new HangmanFactoryServices());
        return injector.getInstance(HangmanPanel.class);
    }

}
