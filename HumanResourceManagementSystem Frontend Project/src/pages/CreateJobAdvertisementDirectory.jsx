import { useFormik } from "formik";
import React, { useEffect, useState } from "react";
import { useHistory } from "react-router-dom";
import * as Yup from "yup";
import {
  Button,
  Dropdown,
  Input,
  TextArea,
  Card,
  Form,
  Grid,
} from "semantic-ui-react";
import WorkTimeService from "../services/workTimeService";
import WorkPlaceService from "../services/workTypeService";
import JobPositionService from "../services/jobPositionService";
import CityService from "../services/cityService";
import JobAdvertisementService from "../services/jobAdvertisementService";

export default function CreateJobAdvertisementDirectory() {
  let jobAdvertisementService = new JobAdvertisementService();

  const JobAdvertAddSchema = Yup.object().shape({
    appealExpirationDate: Yup.date()
      .nullable()
      .required("Bu Alanın Doldurulması Zorunludur"),
    description: Yup.string().required("Bu Alanın Doldurulması Zorunludur"),
    jobtitleId: Yup.string().required("Bu Alanın Doldurulması Zorunludur"),
    workHourId: Yup.string().required("Bu Alanın Doldurulması Zorunludur"),
    workTypeId: Yup.string().required("Bu Alanın Doldurulması Zorunludur"),
    quota: Yup.string()
      .required("Posizyon Sayısı Zorunludur")
      .min(1, "Posizyon Sayısı Birden Küçük Olamaz"),
    cityId: Yup.string().required("Bu Alanın Doldurulması Zorunludur"),
    minSalary: Yup.number()
      .min(0, "0 Dan Az Olamaz")
      .required("Bu Alan Zorunludur"),
    maxSalary: Yup.number()
      .min(0, "0 Dan Az Olamaz")
      .required("Bu Alan Zorunludur"),
  });

  const history = useHistory();
  const formik = useFormik({
    initialValues: {
      description: "",
      jobtitleId: "",
      workHourId: "",
      workTypeId: "",
      quota: "",
      cityId: "",
      minSalary: "",
      maxSalary: "",
      appealExpirationDate: "",
    },
    validationSchema: JobAdvertAddSchema,
    onSubmit: (values) => {
      values.employerId = 8;
      jobAdvertisementService
        .add(values)
        .then((result) => console.log(result.data));
      alert(
        "İş İlanı Sisteme Eklendi Hrms Personelinin Onayı Alındıktan Sonra İş İlanları Sayfasında Listelenecektir."
      );
      console.log(values);
      history.push("/jobads");
    },
  });

  const [workTimes, setWorkTimes] = useState([]);
  const [workPlaces, setWorkPlaces] = useState([]);
  const [cities, setCities] = useState([]);
  const [jobPositions, setJobPositions] = useState([]);

  useEffect(() => {
    let workTimeService = new WorkTimeService();
    let workPlaceService = new WorkPlaceService();
    let cityService = new CityService();
    let jobPositionService = new JobPositionService();

    workTimeService
      .getWorkTimes()
      .then((result) => setWorkTimes(result.data.data));
    workPlaceService
      .getWorkPlaces()
      .then((result) => setWorkPlaces(result.data.data));
    cityService.getAll().then((result) => setCities(result.data.data));
    jobPositionService
      .getJobPositions()
      .then((result) => setJobPositions(result.data.data));
  }, []);

  const workPlaceOption = workPlaces.map((workPlace, index) => ({
    key: index,
    text: workPlace.workType,
    value: workPlace.id,
  }));

  const workTimeOption = workTimes.map((workTime, index) => ({
    key: index,
    text: workTime.workHours,
    value: workTime.id,
  }));

  const cityOption = cities.map((city, index) => ({
    key: index,
    text: city.cityName,
    value: city.id,
  }));

  const jobPositionOption = jobPositions.map((jobPosition, index) => ({
    key: index,
    text: jobPosition.title,
    value: jobPosition.id,
  }));

  const handleChangeSemantic = (value, fieldName) => {
    formik.setFieldValue(fieldName, value);
  };

  return (
    <div>
      <Card fluid>
        <Card.Content header="İş İlanı Ekle" />
        <Card.Content>
          <Form onSubmit={formik.handleSubmit}>
            <Form.Field style={{ marginBottom: "1rem" }}>
              <Dropdown
                clearable
                item
                placeholder="İş Pozisyonu"
                search
                selection
                onChange={(event, data) =>
                  handleChangeSemantic(data.value, "jobtitleId")
                }
                onBlur={formik.onBlur}
                id="jobtitleId"
                value={formik.values.jobtitleId}
                options={jobPositionOption}
              />
              {formik.errors.jobtitleId && formik.touched.jobtitleId && (
                <div className={"ui pointing red basic label"}>
                  {formik.errors.jobtitleId}
                </div>
              )}
            </Form.Field>
            <Form.Field>
              <Dropdown
                clearable
                item
                placeholder="Şehir"
                search
                selection
                onChange={(event, data) =>
                  handleChangeSemantic(data.value, "cityId")
                }
                onBlur={formik.onBlur}
                id="cityId"
                value={formik.values.cityId}
                options={cityOption}
              />
              {formik.errors.cityId && formik.touched.cityId && (
                <div className={"ui pointing red basic label"}>
                  {formik.errors.cityId}
                </div>
              )}
            </Form.Field>
            <Form.Field>
              <Dropdown
                clearable
                item
                placeholder="Çalışma Şekli"
                search
                selection
                onChange={(event, data) =>
                  handleChangeSemantic(data.value, "workTypeId")
                }
                onBlur={formik.onBlur}
                id="workTypeId"
                value={formik.values.workTypeId}
                options={workPlaceOption}
              />
              {formik.errors.workTypeId && formik.touched.workTypeId && (
                <div className={"ui pointing red basic label"}>
                  {formik.errors.workTypeId}
                </div>
              )}
            </Form.Field>
            <Form.Field>
              <Dropdown
                clearable
                item
                placeholder="Çalışma Süresi"
                search
                selection
                onChange={(event, data) =>
                  handleChangeSemantic(data.value, "workHourId")
                }
                onBlur={formik.onBlur}
                id="workHourId"
                value={formik.values.workHourId}
                options={workTimeOption}
              />
              {formik.errors.workHourId && formik.touched.workHourId && (
                <div className={"ui pointing red basic label"}>
                  {formik.errors.workHourId}
                </div>
              )}
            </Form.Field>
            <Form.Field>
              <Grid stackable>
                <Grid.Column width={8}>
                  <Input
                    style={{ width: "100%" }}
                    type="number"
                    placeholder="Minimum Maaş Aralığı"
                    value={formik.values.minSalary}
                    name="minSalary"
                    onChange={formik.handleChange}
                    onBlur={formik.handleBlur}
                  ></Input>
                  {formik.errors.minSalary && formik.touched.minSalary && (
                    <div className={"ui pointing red basic label"}>
                      {formik.errors.minSalary}
                    </div>
                  )}
                </Grid.Column>
                <Grid.Column width={8}>
                  <Input
                    style={{ width: "100%" }}
                    type="number"
                    placeholder="Maksimum Maaş Aralığı"
                    value={formik.values.maxSalary}
                    name="maxSalary"
                    onChange={formik.handleChange}
                    onBlur={formik.handleBlur}
                  ></Input>
                  {formik.errors.maxSalary && formik.touched.maxSalary && (
                    <div className={"ui pointing red basic label"}>
                      {formik.errors.maxSalary}
                    </div>
                  )}
                </Grid.Column>
              </Grid>
            </Form.Field>

            <Form.Field>
              <Grid stackable>
                <Grid.Column width={8}>
                  <Input
                    style={{ width: "100%" }}
                    id="quota"
                    name="quota"
                    error={Boolean(formik.errors.quota)}
                    onChange={formik.handleChange}
                    value={formik.values.quota}
                    onBlur={formik.handleBlur}
                    type="number"
                    placeholder="Kontenjan Sayısı"
                  />
                  {formik.errors.quota && formik.touched.quota && (
                    <div className={"ui pointing red basic label"}>
                      {formik.errors.quota}
                    </div>
                  )}
                </Grid.Column>
                <Grid.Column width={8}>
                  <Input
                    style={{ width: "100%" }}
                    type="datetime-local"
                    error={Boolean(formik.errors.appealExpirationDate)}
                    onChange={(event, data) =>
                      handleChangeSemantic(data.value, "appealExpirationDate")
                    }
                    value={formik.values.appealExpirationDate}
                    onBlur={formik.handleBlur}
                    name="appealExpirationDate"
                    placeholder="Son Başvuru Tarihi"
                  />
                  {formik.errors.appealExpirationDate &&
                    formik.touched.appealExpirationDate && (
                      <div className={"ui pointing red basic label"}>
                        {formik.errors.appealExpirationDate}
                      </div>
                    )}
                </Grid.Column>
              </Grid>
            </Form.Field>

            <Form.Field>
              <TextArea
                placeholder="Açıklama Metni"
                style={{ minHeight: 100 }}
                error={Boolean(formik.errors.description).toString()}
                value={formik.values.description}
                name="description"
                onChange={formik.handleChange}
                onBlur={formik.handleBlur}
              />
              {formik.errors.description && formik.touched.description && (
                <div className={"ui pointing red basic label"}>
                  {formik.errors.description}
                </div>
              )}
            </Form.Field>
            <Button
              content="Ekle"
              labelPosition="right"
              icon="add"
              positive
              type="submit"
              style={{ marginLeft: "20px" }}
            />
          </Form>
        </Card.Content>
      </Card>
    </div>
  );
}
