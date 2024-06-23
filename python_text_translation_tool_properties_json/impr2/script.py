import translators as ts

def ask_proporj():
    """
    Ask the user whether they want to process a properties or JSON file.
    
    :return: True if properties file, False if JSON file.
    """
    proporj = ""
    while proporj.lower() not in ('p', 'j'):
        proporj = input("Properties or JSON file? (p | j): ")
    return proporj == 'p'

def replace_special_characters(text):
    """
    Replace special characters in the given text.
    
    :param text: The text to process.
    :return: The text with special characters replaced.
    """
    return text.replace("'", "&apos;").replace("\"", "&quot;")

def ask_replace():
    """
    Ask the user whether they want to replace special characters.
    
    :return: True if yes, False if no.
    """
    do_replace = ""
    while do_replace.lower() not in ('y', 'n'):
        do_replace = input("Replace special characters? (y | n): ")
    return do_replace == 'y'

def translate_text(t_trans, lang):
    """
    Translate text if the target language is not English.
    
    :param t_trans: Text to translate.
    :param lang: Target language code.
    :return: Translated text.
    """
    return t_trans if lang == 'en' else ts.translate_text(query_text=t_trans, from_language='en', to_language=lang)

def process_line(line, lang, is_properties, replace_special):
    """
    Process a single line of text for a given language.
    
    :param line: The line of text to process.
    :param lang: Target language code.
    :param is_properties: True if processing a properties file, False if JSON.
    :param replace_special: True if replacing special characters, False otherwise.
    :return: Processed line.
    """
    if is_properties:
        txt_first, t_trans = line.split('=', 1)
        txt_translated = translate_text(t_trans, lang)
        return f"{txt_first.strip()}={replace_special_characters(txt_translated.strip()) if replace_special else txt_translated.strip()}\n"
    else:
        t_trans = line.strip()
        txt_translated = translate_text(t_trans, lang)
        return f'"{t_trans}" : "{replace_special_characters(txt_translated.strip()) if replace_special else txt_translated.strip()}",\n'

def process_and_write_lines(input_file, langcodes, is_properties, replace_special, output_file):
    """
    Process and write lines to the output file for each language code.
    
    :param input_file: File object to read lines from.
    :param langcodes: List of language codes.
    :param is_properties: True if processing a properties file, False if JSON.
    :param replace_special: True if replacing special characters, False otherwise.
    :param output_file: File object to write the processed lines to.
    """
    for count, lang in enumerate(langcodes, start=1):
        output_file.write(f"{lang} -- {count}\n\n")
        input_file.seek(0)  # Reset the file pointer to the beginning of the file
        for i, line in enumerate(input_file):
            if i >= 25:  # Limiting to the first 25 lines
                break
            processed_line = process_line(line, lang, is_properties, replace_special)
            output_file.write(processed_line)
        output_file.write('\n\n')

def main():
    try:
        is_properties = ask_proporj()
        replace_special = ask_replace()
        
        print("Processing...")
        langcodes = ['en', 'es', 'fr', 'de', 'ar', 'tr', 'id', 'it', 'lv', 'pt', 'ru', 'zh-Hans', 'zh-Hant', 'mn-Mong']
        
        with open("input.txt", "r", encoding="utf-8") as infile, open("result.txt", "w", encoding="utf-8") as outfile:
            process_and_write_lines(infile, langcodes, is_properties, replace_special, outfile)
        
    except Exception as e:
        print("An exception occurred:", e)

if __name__ == "__main__":
    main()
