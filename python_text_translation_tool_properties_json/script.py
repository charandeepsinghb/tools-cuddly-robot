import translators as ts


try:

    def askproporj():
        proporj = ""
        while not(proporj.lower() == 'p' or proporj.lower() == 'j'):
            proporj = input("Properties or JSON file? (p | j): ")

        return proporj == 'p'


    def replacespecial(str):
        return str.replace("'", "&apos;").replace("\"", "&quot;")

    def askreplace():
        doReplace = ""
        while not(doReplace.lower() == 'y' or doReplace.lower() == 'n'):
            doReplace = input("Replace special characters? (y | n): ")

        return doReplace == 'y'

    isprop = askproporj()
    doReplace = askreplace()
    print("Processing...")
    f = open("input.txt", "r", encoding="utf-8")
    out = open("result.txt", "w+", encoding="utf-8")
    out.close()
    out = open("result.txt", "a", encoding="utf-8")

    langcodes = ['en', 'es', 'fr', 'de', 'ar', 'tr', 'zh-CN', 'zh-TW', 'id', 'it', 'lv', 'pt', 'ru']
    count = 0
    lines = f.readlines()
    for lang in langcodes:
        count += 1
        out.write(lang + ' -- ' + str(count) + '\n\n')
        noOfLines=0
        for line in lines:
            if noOfLines > 25:
                break
            if isprop:
                txt_first = line.split('=')[0]
                t_trans = line.split('=')[1]
                if (lang == 'en'):
                    txt_translated = t_trans
                else:
                    # txt_translated = t_trans
                    txt_translated = ts.google(t_trans, from_language='en', to_language=lang)
                out.write(txt_first.strip() + "=" + (replacespecial(txt_translated.strip()) if doReplace else txt_translated.strip()) + '\n')
            else:
                t_trans = line.split('\n')[0]
                if (lang == 'en'):
                    txt_translated = t_trans
                else:
                    # txt_translated = t_trans
                    txt_translated = ts.google(t_trans, from_language='en', to_language=lang)
                out.write('"' + t_trans.strip() + '" : "' + (replacespecial(txt_translated.strip()) if doReplace else txt_translated.strip()) + '",\n')
            noOfLines += 0

        out.write('\n\n')

    f.close()
    out.close()
except Exception as e:
    print("An exception occured")
