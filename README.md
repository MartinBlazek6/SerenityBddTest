
# SerenityBddTest

UI test that tests my personal website.

## Demo of report

![DEMO](https://martinpersonalweb.vercel.app/_next/image?url=%2Fimages%2FserenityBDDgif.gif&w=3840&q=75)


## Viewing the reports

Both of the commands provided above will produce a Serenity test report in the `target/site/serenity` directory. Go take a look!

## Run Locally

Generate your own report

```bash
  serenity:aggregate -f pom.xml
```

Before running your tests run this 

```bash
  clean -f pom.xml
```


## Environment Variables

To run this project, you will need to add the following environment variables to your .env file

`RUN_TEST_AGAINST_MASTER`


