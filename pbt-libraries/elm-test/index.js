import * as fs from 'fs';
import {Elm} from './elm.js';

const app = Elm.Main.init({
  flags: {
    initialSeed: +new Date(),
    runs: 100,
  }
});

app.ports.writeFile.subscribe(e => fs.writeFileSync(e.filename, e.contents));
